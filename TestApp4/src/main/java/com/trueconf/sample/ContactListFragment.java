package com.trueconf.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.TrueConfListener;
import com.vc.data.enums.PresenceStatus;

import java.util.ArrayList;

public class ContactListFragment extends Fragment implements TrueConfListener.UserStatusEventsCallback {

    private ContactsAdapter adapter;
    private RecyclerView recyclerView;

    public ContactListFragment() {
        super(R.layout.fragment_contacts);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TrueConfSDK.getInstance().addTrueconfListener(this);

        Button addContactBtn = view.findViewById(R.id.add_contact_btn);
        EditText addContactEdit = view.findViewById(R.id.add_contact_edit);
        recyclerView = view.findViewById(R.id.onlineUsers);

        addContactBtn.setOnClickListener(v -> {
            var peerId = addContactEdit.getText().toString();
            var status = TrueConfSDK.getContactsManager().getUserStatus(peerId);
            adapter.updateContact(peerId, status);
        });
        adapter = new ContactsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }

    @Override
    public void onUserStatusUpdate(String id, PresenceStatus status) {
        if (!recyclerView.isComputingLayout()) {
            adapter.updateContact(id, status);
        } else {
            new Handler(Looper.getMainLooper()).post(() -> adapter.updateContact(id, status));
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onContactListUpdate() {
        if (adapter.contacts.size() <= 1) {
            var peerList = TrueConfSDK.getContactsManager().getUsers();
            adapter.contacts.clear();
            adapter.contacts.addAll(peerList);
            adapter.notifyDataSetChanged();
        }
    }
}
