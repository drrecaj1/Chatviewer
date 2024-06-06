package com.example.icachatviewer.data;

public class ChatMessage {
    private String timestamp;
    private String nickname;
    private String content;

    public ChatMessage(String timestamp, String nickname, String content) {
        this.timestamp = timestamp;
        this.nickname = nickname;
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContent() {
        return content;
    }
}
