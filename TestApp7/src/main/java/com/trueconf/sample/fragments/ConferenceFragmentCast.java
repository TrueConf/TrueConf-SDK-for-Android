package com.trueconf.sample.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trueconf.sample.R;
import com.trueconf.sdk.TrueConfListener;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.domain.models.AudioDeviceInfo;
import com.trueconf.sdk.presentation.fragments.ConferenceFragment;

import java.util.List;
import java.util.stream.Collectors;

public class ConferenceFragmentCast extends ConferenceFragment implements TrueConfListener.AudioDeviceCallback, TrueConfListener.VideoDeviceCallback {
    private ImageButton btnMic;
    private ImageButton btnCam;
    private ImageButton btnSpeaker;

    private boolean showDialog = false;

    public ConferenceFragmentCast(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TrueConfSDK.getInstance().addTrueconfListener(this);

        btnMic = view.findViewById(R.id.btnMic);
        btnCam = view.findViewById(R.id.btnCam);
        ImageButton btnFlip = view.findViewById(R.id.btnFlip);
        ImageButton btnClose = view.findViewById(R.id.btnClose);
        btnSpeaker = view.findViewById(R.id.btnSpeaker);

        btnMic.setOnClickListener(view1 -> onSwitchMic());
        btnCam.setOnClickListener(view1 -> onSwitchCamera());
        btnFlip.setOnClickListener(view1 -> onFlipCamera());
        btnSpeaker.setOnClickListener(view1 -> {
            TrueConfSDK.getAudioDeviceController().requestAudioState();
            showDialog = true;
        });
        btnClose.setOnClickListener(view1 -> onHangupClick());
        RelativeLayout gfxFragmentCast = view.findViewById(R.id.gfxFragmentCast);
        ViewGroup insertPoint = view.findViewById(R.id.insert_point);
        addGFXFragment(gfxFragmentCast);
        addGFXSelfViewSurface(insertPoint);
    }

    @Override
    public void onDestroyView() {
        TrueConfSDK.getInstance().removeTrueconfListener(this);
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        TrueConfSDK.getInstance().addTrueconfListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }

    @Override
    public void onVideoDeviceUpdate(boolean videoEnabled) {
        int resId = 0;
        if (videoEnabled) {
            resId = R.drawable.ic_camera;
        } else {
            resId = R.drawable.ic_cam_off;
        }
        btnCam.setImageResource(resId);
    }

    @Override
    public void onAudioDeviceChanged(boolean playerMute, AudioDeviceInfo pair) {
        setupSpeaker(playerMute, pair);
    }

    @Override
    public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {
        setupMic(recorderMute);
        setupSpeaker(playerMute, pair);
    }

    @Override
    public void onAudioDeviceResponse(boolean mutePlayer, boolean muteRecorder, AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {
        if (showDialog) {
            showDialog = false;
            changeAudioDeviceDialog(active, pairs);
        }
    }

    private void setupSpeaker(boolean mutePlayer, AudioDeviceInfo active) {
        var playerResId = 0;
        if (mutePlayer) {
            playerResId = active.getIconResourceMute();
        } else {
            playerResId = active.getIconResource();
        }
        btnSpeaker.setImageResource(playerResId);
    }

    private void setupMic(boolean muteRecorder) {
        var micResId = 0;
        if (muteRecorder) {
            micResId = R.drawable.ic_mic_off;
        } else {
            micResId = R.drawable.ic_mic;
        }
        btnMic.setImageResource(micResId);
    }

    private void changeAudioDeviceDialog(AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {
        List<String> choicesList = pairs.stream().map(AudioDeviceInfo::getDeviceName).collect(Collectors.toList());
        choicesList.add(getString(R.string.turn_off_speakers));
        String[] choices = new String[choicesList.size()];
        choicesList.toArray(choices);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder
                .setTitle("Select new pair")
                .setPositiveButton("Positive", (dialog, which) -> changeAudioDevice((AlertDialog) dialog, pairs))
                .setNegativeButton("Negative", (dialog, which) -> {

                })
                .setSingleChoiceItems(choices, getCheckedItem(active, pairs), (dialog, which) -> {

                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void changeAudioDevice(AlertDialog dialog, List<AudioDeviceInfo> pairs) {
        int selectedPosition = dialog.getListView().getCheckedItemPosition();

        if (selectedPosition > pairs.size() - 1) {
            TrueConfSDK.getAudioDeviceController().muteSpeaker(true);
        } else {
            AudioDeviceInfo selectedDevice = pairs.get(selectedPosition);
            TrueConfSDK.getAudioDeviceController().changeAudioDevice(selectedDevice);
        }
    }

    private int getCheckedItem(AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {
        int index = 0;

        if (TrueConfSDK.getAudioDeviceController().isSpeakerEnabledByDefault()) {
            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).equals(active)) {
                    index = i;
                    break;
                }
            }
        } else {
            index = pairs.size();
        }

        return index;
    }
}
