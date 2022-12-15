package com.techelevator.model;



import org.apache.tomcat.Jar;

import java.time.LocalDateTime;

public class PlayDate {

    private int playDateId;
    private int creatorId;
    private LocalDateTime dateAndTime;
    private String location;
    private String requestMessage;
    private boolean isCancelled;

    public PlayDate(int creatorId, LocalDateTime dateAndTime, String location, String requestMessage, boolean isCancelled) {
        this.creatorId = creatorId;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.requestMessage = requestMessage;
        this.isCancelled = isCancelled;
    }

    public PlayDate() {
    }

    public int getPlayDateId() {
        return playDateId;
    }

    public void setPlayDateId(int playDateId) {
        this.playDateId = playDateId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

//    public Timestamp getDateandtime() {
//        return dateandtime;
//    }
//
//    public void setDateandtime(Timestamp dateandtime) {
//        this.dateandtime = dateandtime;
//    }

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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
