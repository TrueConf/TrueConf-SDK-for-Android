package com.trueconf.sample;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.trueconf.sample.databinding.FragmentPlaceholderBinding;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.TrueConfListener;
import com.vc.jnilib.FSM;

public class PlaceholderFragment3 extends Fragment implements TrueConfListener.LoginEventsCallback,
        TrueConfListener.ServerStatusEventsCallback {

    private EditText mETLogin, mETPass, mETConferenceId;
    private Spinner mETServer;
    private Button mBtnLogin;
    private Button mBtnCall;
    private Button mBtnLogout;
    private TextView mConnectionStatus;

    private String[] data;

    private FragmentPlaceholderBinding binding;

    public PlaceholderFragment3() {
        super(R.layout.fragment_placeholder);
    }

    @Override
    public void onViewCreated(@NonNull View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        binding = FragmentPlaceholderBinding.bind(v);
        data = getResources().getStringArray(R.array.ip_set);
        setUpUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        TrueConfSDK.getInstance().addTrueconfListener(this);
        if (TrueConfSDK.getServerManager().isLoggedIn()) {
            loginOkActions();
        }
    }

    public void onPause() {
        TrueConfSDK.getInstance().removeTrueconfListener(this);
        super.onPause();
    }

    private void afterServerEnter() {
        hideSoftInput();
        String server;
        if (data == null || data.length == 0) {
            server = binding.etServerAdress.getText().toString();
        } else {
            server = mETServer.getSelectedItem().toString();
        }
        boolean isValid = validateInput(server);
        if (isValid) connectToServer(server);
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
        if (TextUtils.isEmpty(server)) {
            return;
        }
        TrueConfSDK.getInstance().start(server, true);
    }

    private void showToast(@StringRes int txt) {
        Toast.makeText(getActivity(), txt, Toast.LENGTH_SHORT).show();
    }

    private void hideSoftInput() {
        var imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mETPass.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void setUpUI() {
        mETLogin = binding.etLogin;
        mETPass = binding.etPass;
        mETConferenceId = binding.etConferenceId;
        mETServer = binding.spServerAdress;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (data == null || data.length == 0) {
            mETServer.setVisibility(View.GONE);
        } else {
            binding.etServerAdress.setVisibility(View.GONE);
        }
        mETServer.setAdapter(adapter);
        mETServer.setSelection(0);
        mBtnLogin = binding.btnLogin;
        binding.btnConnect.setOnClickListener(v1 -> afterServerEnter());
        mBtnLogin.setOnClickListener(btn -> onLoginClick());
        mConnectionStatus = binding.tvConnectionState;
        mBtnCall = binding.btnCall;
        mBtnCall.setOnClickListener(v1 -> {
            var conferenceId = mETConferenceId.getText().toString();
            if (!conferenceId.isEmpty()) {
                TrueConfSDK.getConferenceManager().joinConf(conferenceId);
            }
        });
        mBtnLogout = binding.btnLogout;
        mBtnLogout.setOnClickListener(v1 ->
                TrueConfSDK.getServerManager().logout()
        );
    }

    private void onLoginClick() {
        hideSoftInput();
        var username = mETLogin.getText().toString().trim();
        var password = mETPass.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            showToast(R.string.msg_empty_login_or_pass);
        } else {
            TrueConfSDK.getServerManager().loginAs(username, password, true, false);
        }
    }

    private void loginOkActions() {
        mBtnCall.setVisibility(View.VISIBLE);
        mETConferenceId.setVisibility(View.VISIBLE);
        mBtnLogout.setVisibility(View.VISIBLE);
        binding.tvCallTo.setVisibility(View.VISIBLE);
        mBtnLogin.setVisibility(View.GONE);
    }

    @Override
    public void onLogin(boolean loggedIn, String userId) {
        if (loggedIn) {
            loginOkActions();
        }
    }

    @Override
    public void onLogout() {
        mBtnCall.setVisibility(View.GONE);
        mETConferenceId.setVisibility(View.GONE);
        mBtnLogin.setVisibility(View.VISIBLE);
        mBtnLogout.setVisibility(View.GONE);
        binding.tvCallTo.setVisibility(View.GONE);
    }

    @Override
    public void onServerStatus(boolean connected, String serverName, int port) {
        if (connected && !TrueConfSDK.getServerManager().isLoggedIn()) {
            mConnectionStatus.setText(R.string.state_connected);
            mConnectionStatus.setText(R.string.state_connected);
            mETLogin.setVisibility(View.VISIBLE);
            mETPass.setVisibility(View.VISIBLE);
            mBtnLogin.setVisibility(View.VISIBLE);
            mBtnLogout.setVisibility(View.GONE);
            binding.tvLoginPass.setVisibility(View.VISIBLE);
        } else if (!connected) {
            mConnectionStatus.setText(R.string.state_disconnected);
            mETLogin.setVisibility(View.GONE);
            mETPass.setVisibility(View.GONE);
            mBtnLogin.setVisibility(View.GONE);
            binding.tvLoginPass.setVisibility(View.GONE);
            mBtnCall.setVisibility(View.GONE);
            mETConferenceId.setVisibility(View.GONE);
            mBtnLogout.setVisibility(View.GONE);
            binding.tvCallTo.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStateChanged(FSM.State newState) {}
}
