package com.trueconf.sample;

import androidx.annotation.NonNull;

public class ChatMessage implements Comparable<ChatMessage> {

    private static final int BEFORE = -1;
    private static final int EQUAL = 0;
    private static final int AFTER = 1;
    public final String interlocutor;
    public final String chatId;
    public final String message;
    public final long date;
    public final int count;
    public final boolean isMultiRecipient;

    public ChatMessage(String interlocutor, String chatId, String message,
                       long date, int count, boolean isMultiRecipient) {
        this.interlocutor = interlocutor;
        this.chatId = chatId;
        this.message = message;
        this.date = date;
        this.count = count;
        this.isMultiRecipient = isMultiRecipient;
    }

    @NonNull
    @Override
    public String toString() {
        return "ChatMessage [interlocutor=" + interlocutor + ", message="
                + message + ", date=" + date + ", count=" + count
                + ", isMultiRecipient=" + isMultiRecipient + "]";
    }

    // sort by date descending
    @Override
    public int compareTo(@NonNull ChatMessage another) {
        if (this == another) {
            return EQUAL;
        }
        if (date > another.date) {
            return BEFORE;
        } else if (date < another.date) {
            return AFTER;
        }
        return EQUAL;
    }
}
