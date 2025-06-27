package com.trueconf.sample;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.trueconf.sdk.TrueConfSDK;

public class LoginDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_login, null);

        final EditText etName = view.findViewById(R.id.username);
        final EditText etPassword = view.findViewById(R.id.password);

        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.login, (dialog, id) -> {
                    // Sign in the user.
                    String username = etName.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                        Toast.makeText(requireContext(), R.string.msg_empty_login_or_pass, Toast.LENGTH_SHORT).show();
                    } else {
                        TrueConfSDK.getServerManager().loginAs(username, password, true, true);
                    }
                });
        return builder.create();
    }

}
