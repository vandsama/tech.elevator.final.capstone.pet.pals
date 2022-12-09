package com.techelevator.model;

public class Message {

    private int message_id;
    private int user_id;
    private int topic_id;
    private String title;
    private String text;

    public Message() {}

    public Message(int message_id, int user_id, int topic_id, String title, String text) {
        this.message_id = message_id;
        this.user_id = user_id;
        this.topic_id = topic_id;
        this.title = title;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
