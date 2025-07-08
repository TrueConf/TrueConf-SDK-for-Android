package com.trueconf.sample;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.trueconf.sample.databinding.FragmentPlaceholderBinding;
import com.trueconf.sdk.TrueConfListener;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.domain.models.AudioDeviceInfo;
import com.vc.jnilib.FSM;

import java.util.List;
import java.util.stream.Collectors;

public class PlaceholderFragment7 extends Fragment implements TrueConfListener.LoginEventsCallback,
        TrueConfListener.ServerStatusEventsCallback, TrueConfListener.AudioDeviceCallback {

    private EditText etServerId, etUserId;
    private ImageButton btnLogin;
    private TextView tvConnectionStatus;

    private InputMethodManager imm;

    private FragmentPlaceholderBinding binding;

    private boolean showDialog = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TrueConfSDK.getInstance().addTrueconfListener(this);
        binding = FragmentPlaceholderBinding.bind(view);
        imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        setUpUI();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (TrueConfSDK.getServerManager().isLoggedIn()) {
            loginOkActions();
        }
    }

    private void afterServerEnter() {
        hideSoftInput(etUserId);
        var server = etServerId.getText().toString();
        if (validateInput(server)) {
            connectToServer(server);
        }
    }

    private boolean validateInput(String server) {
        if (server.contains(":")) {
            String[] array = server.split(":");
            if (array.length != 2) {
                showToast(R.string.msg_invalid_server_port_value);
                return false;
            }
            int port;
            try {
                port = Integer.parseInt(array[1]);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                return false;
            }
            if (port < 0 || port > 65535) {
                showToast(R.string.msg_invalid_server_port_value);
                return false;
            }
        }
        return true;
    }

    private void connectToServer(final String server) {
        if (server.isEmpty()) {
            return;
        }
        TrueConfSDK.getInstance().start(server, true);
        TrueConfSDK.getInstance().addTrueconfListener(this);
    }

    private void showToast(@StringRes int txt) {
        Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show();
    }

    private void hideSoftInput(View view) {
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void setUpUI() {
        etServerId = binding.etServerAddress;
        etUserId = binding.etPeerId;
        tvConnectionStatus = binding.tvConnectionState;
        btnLogin = binding.btnLogin;

        binding.btnConnect.setOnClickListener(v1 -> afterServerEnter());

        binding.btnSpeaker.setOnClickListener(v1 -> {
            TrueConfSDK.getAudioDeviceController().requestAudioState();
            showDialog = true;
        });

        binding.btnCall.setOnClickListener(v1 -> {
            if (!etUserId.getText().toString().isEmpty()) {
                TrueConfSDK.getConferenceManager().callTo(etUserId.getText().toString());
            } else {
                showToast(R.string.empty_id);
            }
            hideSoftInput(v1);
        });

        btnLogin.setOnClickListener(view -> {
            if (TrueConfSDK.getServerManager().isLoggedIn()) {
                TrueConfSDK.getServerManager().logout();
            } else {
                DialogFragment newFragment = new LoginDialogFragment();
                newFragment.show(requireActivity().getSupportFragmentManager(), "LoginDialogFragment");
            }
        });

        binding.btnStop.setOnClickListener(view -> {
            TrueConfSDK.getInstance().removeTrueconfListener(this);
            TrueConfSDK.getInstance().stop();
            updateConnectionStatus();
        });
    }

    private void updateConnectionStatus() {
        boolean isConnectedToServer = TrueConfSDK.getServerManager().isConnectedToServer();
        boolean isLoggedIn = TrueConfSDK.getServerManager().isLoggedIn();
        if (!TrueConfSDK.isStarted()) {
            tvConnectionStatus.setText("");
            binding.layoutCall.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
        } else if (!isConnectedToServer) {
            tvConnectionStatus.setText(R.string.state_disconnected);
            tvConnectionStatus.setTextColor(requireContext().getColor(R.color.theme_red_pressed));
            binding.layoutCall.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
        } else if (!isLoggedIn) {
            tvConnectionStatus.setText(R.string.state_connected);
            tvConnectionStatus.setTextColor(requireContext().getColor(R.color.theme_green_pressed));
            binding.layoutCall.setVisibility(View.GONE);
            btnLogin.setVisibility(View.VISIBLE);
        } else {
            tvConnectionStatus.setText(R.string.state_connected);
            tvConnectionStatus.setTextColor(requireContext().getColor(R.color.theme_green_pressed));
            binding.layoutCall.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLogin(boolean loggedIn, String userId) {
        if (loggedIn) {
            loginOkActions();
        }
    }

    @Override
    public void onLogout() {
        logout();
    }

    private void loginOkActions() {
        btnLogin.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_logout));
    }

    public void logout() {
        btnLogin.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_login));
    }

    @Override
    public void onStateChanged(FSM.State newState) {
        updateConnectionStatus();
    }

    @Override
    public void onServerStatus(boolean connected, String serverName, int port) { }

    @Override
    public void onAudioDeviceChanged(boolean playerMute, AudioDeviceInfo pair) {

    }

    @Override
    public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {

    }

    @Override
    public void onAudioDeviceResponse(boolean mutePlayer, boolean muteRecorder, AudioDeviceInfo active, List<AudioDeviceInfo> pairs) {
        if (showDialog) {
            changeAudioDeviceDialog(active, pairs);
            showDialog = false;
        }
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

        int resId = 0;
        if (selectedPosition > pairs.size() - 1) {
            TrueConfSDK.getAudioDeviceController().setDefaultSpeakerEnabled(false);
            resId = R.drawable.round_volume_off_24;
        } else {
            AudioDeviceInfo selectedDevice = pairs.get(selectedPosition);
            TrueConfSDK.getAudioDeviceController().setDefaultAudioDevice(selectedDevice);
            resId = selectedDevice.getIconResource();
        }

        binding.btnSpeaker.setImageResource(resId);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }
}
