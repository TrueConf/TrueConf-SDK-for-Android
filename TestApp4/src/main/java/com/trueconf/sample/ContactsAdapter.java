package com.trueconf.sample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trueconf.sample.databinding.ListItemLayoutBinding;
import com.trueconf.sdk.domain.models.ContactInfo;
import com.vc.data.enums.PresenceStatus;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    List<ContactInfo> contacts;

    ContactsAdapter(List<ContactInfo> contacts) {
        this.contacts = contacts;
    }

    @Override
    @NonNull
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(ListItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        var peerDescription = contacts.get(position);
        var peerId = peerDescription.getId();
        var status = peerDescription.getStatus();
        var text = peerId + " " + getStatusEmoji(status);
        holder.binding.text.setText(text);
    }

    private String getStatusEmoji(PresenceStatus status) {
        switch (status) {
            case ONLINE:
                return "🟢 Online";
            case BUSY:
                return "🟠 Busy";
            case MULTIHOST:
                return "⭐️ Owner";
            case LOGOFF:
                return "🔴 Offline";
            case INVALID:
            case UNDEFINED:
                return "❔ Unknown";
            default:
                return "🔄 " + status.toString();
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void updateContact(String peerId, PresenceStatus status) {
        boolean findContact = false;
        for (int i = 0; i < contacts.size(); i++) {
            ContactInfo contact = contacts.get(i);
            if (contact.getId().equals(peerId)) {
                contact.setStatus(status);
                notifyItemChanged(i);
                findContact = true;
                break;
            }
        }

        if (!findContact) {
            contacts.add(new ContactInfo(peerId, status));
        }
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        final ListItemLayoutBinding binding;

        public ContactViewHolder(ListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
