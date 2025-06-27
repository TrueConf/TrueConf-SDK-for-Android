package com.trueconf.sample;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trueconf.sample.databinding.ChatRowItemBinding;

import java.util.ArrayList;

public class ChatPageMsgsRecyclerAdapter extends RecyclerView.Adapter<ChatPageMsgsRecyclerAdapter.ChatMsgsViewHolder> {

    private final ArrayList<ChatModel> messages =  new ArrayList<>();

    public ChatPageMsgsRecyclerAdapter() {}

    public void addNewMessage(String fromId, String fromName, String text, String outId, boolean isOut) {
        messages.add(new ChatModel(fromId, fromName, text, outId, isOut));
        notifyItemInserted(messages.size() - 1);
    }

    @Override
    @NonNull
    public ChatMsgsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatMsgsViewHolder(ChatRowItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMsgsViewHolder holder, int position) {
        String msgText = messages.get(position).getText();
        final boolean outgoing = messages.get(position).getIsOutgoing();
//        final String senderId = messages.get(position).getFromId();
        final String senderName = messages.get(position).getFromName();

        var tvMsgOutgoing = holder.binding.tvChatMsgOutgoing;
        var tvMsgIncoming = holder.binding.tvChatMsgIncoming;
        var tvMsgIncomingSender = holder.binding.tvChatMsgIncomingAuthor;

        holder.binding.messageOut.setVisibility(outgoing ? View.VISIBLE : View.GONE);
        holder.binding.messageIn.setVisibility(outgoing ? View.GONE : View.VISIBLE);
        tvMsgOutgoing.setVisibility(outgoing ? View.VISIBLE : View.GONE);
        tvMsgIncoming.setVisibility(outgoing ? View.GONE : View.VISIBLE);
        if (outgoing) {
            tvMsgOutgoing.setMovementMethod(LinkMovementMethod.getInstance());
            tvMsgOutgoing.setText(msgText);
            tvMsgOutgoing.setFocusable(false);
            tvMsgIncomingSender.setVisibility(View.GONE);
        } else {
            tvMsgIncoming.setMovementMethod(LinkMovementMethod.getInstance());
            tvMsgIncoming.setText(msgText);
            tvMsgIncoming.setFocusable(false);
            tvMsgIncomingSender.setText(senderName);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class ChatMsgsViewHolder extends RecyclerView.ViewHolder {

        final ChatRowItemBinding binding;

        public ChatMsgsViewHolder(ChatRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
