package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class PlayDate {

    private int playDateId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateandtime;
    private String location;
    private String requestMessage;

    public PlayDate(int playDateId, Timestamp dateandtime, String location, String requestMessage) {
        this.playDateId = playDateId;
        this.dateandtime = dateandtime;
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

    public Timestamp getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(Timestamp dateandtime) {
        this.dateandtime = dateandtime;
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
