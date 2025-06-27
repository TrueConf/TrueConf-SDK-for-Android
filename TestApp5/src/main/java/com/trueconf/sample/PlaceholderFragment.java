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
import com.vc.data.enums.ConnectionEvents;
import com.vc.jnilib.FSM;

public class PlaceholderFragment extends Fragment implements TrueConfListener.LoginEventsCallback,
        TrueConfListener.ServerStatusEventsCallback {

    private EditText mETLogin, mETPass, mETServerId, mETUserId;
    private Spinner mETServer;
    private Button mBtnLogin;
    private Button mBtnCall;
    private Button mBtnLogout;
    private TextView mConnectionStatus, mTvLoginPass;

    private InputMethodManager imm;
    private String[] data;

    private FragmentPlaceholderBinding binding;

    public PlaceholderFragment() {
        super(R.layout.fragment_placeholder);
    }

    @Override
    public void onViewCreated(@NonNull View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        TrueConfSDK.getInstance().addTrueconfListener(this);
        binding = FragmentPlaceholderBinding.bind(v);
        imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        data = getResources().getStringArray(R.array.ip_set);
        setUpUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (TrueConfSDK.getServerManager().isLoggedIn()) {
            loginOkActions();
        }
    }

    private void afterServerEnter() {
        hideSoftInput();
        String server;
        if (data == null || data.length == 0) {
            server = mETServerId.getText().toString();
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
        imm.hideSoftInputFromWindow(mETPass.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void setUpUI() {
        mETLogin = binding.etLogin;
        mETPass = binding.etPass;
        mETUserId = binding.etCallToPeer;
        mETServer = binding.spServerAdress;
        mETServerId = binding.etServerAdress;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (data == null || data.length == 0) {
            mETServer.setVisibility(View.GONE);
        } else {
            mETServerId.setVisibility(View.GONE);
        }
        mETServer.setAdapter(adapter);
        mETServer.setSelection(0);
        mBtnLogin = binding.btnLogin;
        binding.btnConnect.setOnClickListener(v1 -> afterServerEnter());
        mBtnLogin.setOnClickListener(btn -> {
            hideSoftInput();
            var username = mETLogin.getText().toString().trim();
            var password = mETPass.getText().toString().trim();
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                showToast(R.string.msg_empty_login_or_pass);
            } else {
                TrueConfSDK.getServerManager().loginAs(username, password, true, false);
            }
        });
        mConnectionStatus = binding.tvConnectionState;
        mBtnCall = binding.btnCall;
        mBtnCall.setOnClickListener(btn -> {
            var peerId = mETUserId.getText().toString();
            if (!peerId.isEmpty()) {
                TrueConfSDK.getConferenceManager().callTo(peerId);
            }
        });
        mBtnLogout = binding.btnLogout;
        mBtnLogout.setOnClickListener(v1 -> TrueConfSDK.getServerManager().logout());
        mTvLoginPass = binding.tvLoginPass;
    }

    private void updateConnectionStatus() {
        boolean isConnectedToServer = TrueConfSDK.getServerManager().isConnectedToServer();
        if (isConnectedToServer && !TrueConfSDK.getServerManager().isLoggedIn()) {
            mConnectionStatus.setText(R.string.state_connected);
            mETLogin.setVisibility(View.VISIBLE);
            mETPass.setVisibility(View.VISIBLE);
            mBtnLogin.setVisibility(View.VISIBLE);
            mBtnLogout.setVisibility(View.GONE);
            mTvLoginPass.setVisibility(View.VISIBLE);
        } else if (!isConnectedToServer) {
            mConnectionStatus.setText(R.string.state_disconnected);
            mETLogin.setVisibility(View.GONE);
            mETPass.setVisibility(View.GONE);
            mBtnLogin.setVisibility(View.GONE);
            mBtnLogout.setVisibility(View.GONE);
            mTvLoginPass.setVisibility(View.GONE);
            mBtnCall.setVisibility(View.GONE);
            mETUserId.setVisibility(View.GONE);
            binding.tvCallTo.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }

    private void loginOkActions() {
        mBtnCall.setVisibility(View.VISIBLE);
        mETUserId.setVisibility(View.VISIBLE);
        mBtnLogout.setVisibility(View.VISIBLE);
        requireView().findViewById(R.id.tv_call_to).setVisibility(View.VISIBLE);
        mBtnLogin.setVisibility(View.GONE);
    }

    public void logout() {
        mBtnCall.setVisibility(View.GONE);
        mETUserId.setVisibility(View.GONE);
        requireView().findViewById(R.id.tv_call_to).setVisibility(View.GONE);
        mBtnLogin.setVisibility(View.VISIBLE);
        mBtnLogout.setVisibility(View.GONE);
    }

    @Override
    public void onLogin(boolean loggedIn, String s) {
        if (loggedIn) {
            loginOkActions();
        }
    }

    @Override
    public void onLogout() {
        logout();
    }

    @Override
    public void onServerStatus(boolean b, String s, int i) {
        updateConnectionStatus();
    }

    @Override
    public void onStateChanged(FSM.State newState) {}
}
