package com.trueconf.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trueconf.sample.databinding.FragmentChatPageBinding;
import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.TrueConfListener;

public class ChatPageFragment extends Fragment implements TrueConfListener.ChatEventsCallback {

    private ChatPageMsgsRecyclerAdapter mAdapter;

    public ChatPageFragment() {}

    @Override
    public void onChatMessageReceived(String fromId, String fromName, String text, String toId) {
        mAdapter.addNewMessage(fromId, fromName, text, toId, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentChatPageBinding binding = FragmentChatPageBinding.bind(view);
        view.findViewById(R.id.chat_action_button).setOnClickListener(v -> {
            var receiverId = binding.toolbar.etTo.getText().toString();
            var messageText = binding.toolbar.etChatMessage.getText().toString();
            TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
            mAdapter.addNewMessage(TrueConfSDK.getContactsManager().getMyId(), TrueConfSDK.getContactsManager().getMyName(),
                    messageText, receiverId, true);
        });
        RecyclerView messagesRecycler = binding.ptflChatPage;
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        messagesRecycler.setLayoutManager(layoutManager);
        mAdapter = new ChatPageMsgsRecyclerAdapter();
        messagesRecycler.setAdapter(mAdapter);
        TrueConfSDK.getInstance().addTrueconfListener(this);
    }
}
