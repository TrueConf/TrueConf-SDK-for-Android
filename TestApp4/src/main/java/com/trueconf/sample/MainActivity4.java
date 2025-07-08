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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.trueconf.sample.databinding.ActivityMainBinding;
import com.trueconf.sample.databinding.FragmentPlaceholderBinding;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.TrueConfListener;
import com.vc.jnilib.FSM;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setTitle("Example 4. Working with User Statuses");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity4.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(binding.container.getId(), new PlaceholderFragment())
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment implements TrueConfListener.LoginEventsCallback,
            TrueConfListener.ServerStatusEventsCallback {

        private EditText mETLogin, mETPass, mETServerId;
        private Spinner mETServer;
        private Button mBtnLogin;
        private InputMethodManager imm;
        private String[] data;
        private FragmentPlaceholderBinding binding;

        public PlaceholderFragment() {
            super(R.layout.fragment_placeholder);
        }

        @Override
        public void onViewCreated(@NonNull View v, Bundle savedInstanceState) {
            super.onViewCreated(v, savedInstanceState);
            binding = FragmentPlaceholderBinding.bind(v);
            data = getResources().getStringArray(R.array.ip_set);
            imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            setUpUI();
            TrueConfSDK.getInstance().addTrueconfListener(this);
        }

        @Override
        public void onPause() {
            TrueConfSDK.getInstance().removeTrueconfListener(this);
            super.onPause();
        }

        @Override
        public void onLogin(boolean loggedIn, String userId) {
            if (loggedIn) {
                TrueConfSDK.getContactsManager().getUsers();
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ContactListFragment())
                        .commit();
            }
        }

        @Override
        public void onLogout() {
            mBtnLogin.setVisibility(View.VISIBLE);
        }

        @Override
        public void onStateChanged(FSM.State newState) {
        }

        @Override
        public void onServerStatus(boolean connected, String serverName, int port) {
            var mConnectionStatus = binding.tvConnectionState;
            var mTvLoginPass = binding.tvLoginPass;
            if (connected && !TrueConfSDK.getServerManager().isLoggedIn()) {
                mConnectionStatus.setText(R.string.state_connected);
                mETLogin.setVisibility(View.VISIBLE);
                mETPass.setVisibility(View.VISIBLE);
                mBtnLogin.setVisibility(View.VISIBLE);
                mTvLoginPass.setVisibility(View.VISIBLE);
            } else if (!connected) {
                mConnectionStatus.setText(R.string.state_disconnected);
                mETLogin.setVisibility(View.GONE);
                mETPass.setVisibility(View.GONE);
                mBtnLogin.setVisibility(View.GONE);
                mTvLoginPass.setVisibility(View.GONE);
            }
        }

        private void setUpUI() {
            mETLogin = binding.etLogin;
            mETPass = binding.etPass;
            mETServer = binding.spServerAdress;
            mETServerId = binding.etServerAdress;
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                    android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            if (data == null || data.length == 0) {
                mETServer.setVisibility(View.GONE);
            } else {
                mETServerId.setVisibility(View.GONE);
            }
            mETServer.setAdapter(adapter);
            mETServer.setSelection(0);
            mBtnLogin = binding.btnLogin;
            mBtnLogin.setOnClickListener(v -> onLoginClick());
            binding.btnConnect.setOnClickListener(v -> afterServerEnter());
            binding.btnLogout.setOnClickListener(v -> TrueConfSDK.getServerManager().logout());
        }

        private void onLoginClick() {
            imm.hideSoftInputFromWindow(mETPass.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            var username = mETLogin.getText().toString().trim();
            var password = mETPass.getText().toString().trim();
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(requireContext(),
                        getString(R.string.msg_empty_login_or_pass),
                        Toast.LENGTH_SHORT).show();
            } else {
                TrueConfSDK.getServerManager().loginAs(username, password, true, false);
            }
        }

        private void afterServerEnter() {
            imm.hideSoftInputFromWindow(mETPass.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            String server;
            if (data == null || data.length == 0) {
                server = mETServerId.getText().toString();
            } else {
                server = mETServer.getSelectedItem().toString();
            }
            if (server.contains(":")) {
                String[] array = server.split(":");
                if (array.length == 2) {
                    int port = -1;
                    try {
                        port = Integer.parseInt(array[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (port >= 0 && port <= 65535) {
                        connectToServer(server);
                    } else {
                        Toast.makeText(requireContext(),
                                R.string.msg_invalid_server_port_value,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(),
                            R.string.msg_invalid_server_port_value,
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                connectToServer(server);
            }
        }

        private void connectToServer(final String server) {
            if (server != null && server.length() > 0) {
                TrueConfSDK.getInstance().start(server, true);
            }
        }
    }
}
