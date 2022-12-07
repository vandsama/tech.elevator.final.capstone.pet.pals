package com.techelevator.dao;

import com.techelevator.model.PlayDate;

import java.util.List;

public interface PlayDateDao {


    List<PlayDate> listAllPlayDates();

    PlayDate getPlayDateById(int playDateId);
}
