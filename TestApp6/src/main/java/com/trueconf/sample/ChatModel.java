package com.trueconf.sample;

public class ChatModel {

    private final String fromId;
    private final String fromName;
    private final String outId;
    private final String text;
    private final boolean isOutgoing;

    public ChatModel(String fromId, String fromName, String text, String outId, boolean isOutgoing) {
        this.fromId = fromId;
        this.fromName = fromName;
        this.text = text;
        this.outId = outId;
        this.isOutgoing = isOutgoing;
    }

    public String getFromId() {
        return fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public String getText() {
        return text;
    }

    public String getOutId() {
        return outId;
    }

    public boolean getIsOutgoing() {
        return isOutgoing;
    }
}
