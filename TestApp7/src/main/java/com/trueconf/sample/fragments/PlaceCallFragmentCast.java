package com.trueconf.sample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trueconf.sample.R;
import com.trueconf.sdk.TrueConfListener;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.domain.models.AudioDeviceInfo;
import com.trueconf.sdk.presentation.fragments.PlaceCallFragment;

import java.util.List;

public class PlaceCallFragmentCast extends PlaceCallFragment implements TrueConfListener.AudioDeviceCallback, TrueConfListener.VideoDeviceCallback {
    private ImageButton btnMic;
    private ImageButton btnCamera;

    public PlaceCallFragmentCast(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return super.onCreateView(inflater, parent, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TrueConfSDK.getInstance().addTrueconfListener(this);

        ImageButton btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this::onHangupClick);

        btnMic = view.findViewById(R.id.btnMic);
        btnMic.setOnClickListener(view1 -> onSwitchMic());
        btnCamera = view.findViewById(R.id.btnCam);
        btnCamera.setOnClickListener(view1 -> onSwitchCamera());

        ViewGroup insertPoint = view.findViewById(R.id.insert_point);

        addGFXSelfViewSurface(insertPoint);
    }

    @Override
    public void onDestroyView() {
        TrueConfSDK.getInstance().removeTrueconfListener(this);
        super.onDestroyView();
    }

    @Override
    public void onHangupClick(View view) {
        super.onHangupClick(view);
        Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onVideoDeviceUpdate(boolean videoEnabled) {
        int resId = 0;
        if (videoEnabled) {
            resId = R.drawable.ic_camera;
        } else {
            resId = R.drawable.ic_cam_off;
        }
        btnCamera.setImageResource(resId);
    }

    @Override
    public void onAudioDeviceChanged(boolean playerMute, AudioDeviceInfo pair) {

    }

    @Override
    public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {
        setupAudioUi(recorderMute);
    }

    @Override
    public void onAudioDeviceResponse(boolean mutePlayer, boolean muteRecorder, AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {
        setupAudioUi(muteRecorder);
    }

    private void setupAudioUi(boolean muteRecorder) {
        var micResId = 0;
        if (muteRecorder) {
            micResId = R.drawable.ic_mic_off;
        } else {
            micResId = R.drawable.ic_mic;
        }
        btnMic.setImageResource(micResId);
    }
}
