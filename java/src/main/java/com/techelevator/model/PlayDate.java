package com.techelevator.model;

import java.sql.Timestamp;

public class PlayDate {

    private int playDateId;
    private Timestamp timestamp;
    private String location;
    private String requestMessage;
    private int inviterUserId;
    private int inviterPetId;
    private int inviteeUserId;
    private int inviteePetId;

    public PlayDate(int playDateId, Timestamp timestamp, String location, String requestMessage, int inviterUserId, int inviterPetId, int inviteeUserId, int inviteePetId) {
        this.playDateId = playDateId;
        this.timestamp = timestamp;
        this.location = location;
        this.requestMessage = requestMessage;
        this.inviterUserId = inviterUserId;
        this.inviterPetId = inviterPetId;
        this.inviteeUserId = inviteeUserId;
        this.inviteePetId = inviteePetId;
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

    public int getInviterUserId() {
        return inviterUserId;
    }

    public void setInviterUserId(int inviterUserId) {
        this.inviterUserId = inviterUserId;
    }

    public int getInviterPetId() {
        return inviterPetId;
    }

    public void setInviterPetId(int inviterPetId) {
        this.inviterPetId = inviterPetId;
    }

    public int getInviteeUserId() {
        return inviteeUserId;
    }

    public void setInviteeUserId(int inviteeUserId) {
        this.inviteeUserId = inviteeUserId;
    }

    public int getInviteePetId() {
        return inviteePetId;
    }

    public void setInviteePetId(int inviteePetId) {
        this.inviteePetId = inviteePetId;
    }
}
