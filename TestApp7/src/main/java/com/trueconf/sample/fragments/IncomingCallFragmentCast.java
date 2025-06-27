package com.trueconf.sample.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trueconf.sample.R;
import com.trueconf.sdk.TrueConfListener;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.domain.models.AudioDeviceInfo;
import com.trueconf.sdk.presentation.fragments.IncomingCallFragment;

import java.util.List;

public class IncomingCallFragmentCast extends IncomingCallFragment implements TrueConfListener.AudioDeviceCallback, TrueConfListener.VideoDeviceCallback {
    private ImageButton btnMic, btnCam;

    public IncomingCallFragmentCast(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TrueConfSDK.getInstance().addTrueconfListener(this);

        ViewGroup insertPoint = view.findViewById(R.id.insert_point);

        addGFXSelfViewSurface(insertPoint);

        ImageView btnAccept = view.findViewById(R.id.btn_accept);
        btnAccept.setOnClickListener(view1 -> onAcceptClick());

        ImageView btnDecline = view.findViewById(R.id.btn_decline);
        btnDecline.setOnClickListener(view1 -> onDeclineClick());

        btnMic = view.findViewById(R.id.btnMic);
        btnCam = view.findViewById(R.id.btnCam);

        btnMic.setOnClickListener(view1 -> onSwitchMic());
        btnCam.setOnClickListener(view1 -> onSwitchCamera());
    }

    @Override
    public void onDestroyView() {
        TrueConfSDK.getInstance().removeTrueconfListener(this);
        super.onDestroyView();
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

    }

    @Override
    public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {
        setupAudioUi(recorderMute);
    }

    private void setupAudioUi(boolean recorderMute) {
        var micResId = 0;
        if (recorderMute) {
            micResId = R.drawable.ic_mic_off;
        } else {
            micResId = R.drawable.ic_mic;
        }
        btnMic.setImageResource(micResId);
    }

    @Override
    public void onAudioDeviceResponse(boolean mutePlayer, boolean muteRecorder, AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {

    }
}
