package com.techelevator.model;

import java.sql.Timestamp;

public class Topic {

    private int id;
    private Timestamp timestamp;
    private String title;

    public Topic() {}

    public Topic(int id, Timestamp timestamp, String title) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
