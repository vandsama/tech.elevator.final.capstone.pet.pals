package com.techelevator.dao;

import com.techelevator.model.PlayDate;

import java.time.LocalDateTime;
import java.util.List;

public interface PlayDateDao {


    List<PlayDate> listAllPlayDates();

    List<PlayDate> listMyPlayDates(int userId);

    PlayDate getPlayDateById(int playDateId);


    int schedulePlayDate(int creatorId, LocalDateTime dateAndTime, String location, String requestMessage);


    void addPetsToPlaydate(int[] petIds, int playdateId);

    void cancelPlaydate(int playdateId);

    List<PlayDate> getPlaydatesUserCreated(int userId);
}
