package com.techelevator.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PlayDate {

    private int playDateId;
    private LocalDateTime dateAndTime;
    private String location;
    private String requestMessage;

    public PlayDate(LocalDateTime dateAndTime, String location, String requestMessage) {
        this.dateAndTime = dateAndTime;
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

}
