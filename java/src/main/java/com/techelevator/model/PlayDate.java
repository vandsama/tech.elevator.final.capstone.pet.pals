package com.techelevator.model;

import java.sql.Timestamp;

public class PlayDate {

    private int playDateId;
    private Timestamp timestamp;
    private String location;
    private String requestMessage;

    public PlayDate(int playDateId, Timestamp timestamp, String location, String requestMessage) {
        this.playDateId = playDateId;
        this.timestamp = timestamp;
        this.location = location;
        this.requestMessage = requestMessage;
    }

    public PlayDate() {
    }

    public int getPlayDateId() {
        return playDateId;
    }

    public void setPlayDateId(int playDateId) {
        this.playDateId = playDateId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

}
