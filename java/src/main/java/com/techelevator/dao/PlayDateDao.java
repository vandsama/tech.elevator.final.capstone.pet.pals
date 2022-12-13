package com.techelevator.dao;

import com.techelevator.model.PlayDate;

import java.sql.Timestamp;
import java.util.List;

public interface PlayDateDao {


    List<PlayDate> listAllPlayDates();

    List<PlayDate> listMyPlayDates(int userId);

    PlayDate getPlayDateById(int playDateId);

    boolean schedulePlayDate(Timestamp dateAndTime, String location, String requestMessage);
}
