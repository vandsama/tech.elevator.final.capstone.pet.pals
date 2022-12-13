package com.techelevator.dao;

import com.techelevator.model.PlayDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlayDateDao implements PlayDateDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayDateDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<PlayDate> listAllPlayDates() {
        List<PlayDate> playDateList = new ArrayList<>();
        String sql = "SELECT playdate_id, dateandtime, location, requestmessage\n" +
                "\tFROM public.playdates;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()) {
            playDateList.add(mapRowToPlayDate(result));
        }

        return playDateList;
    }

    @Override
    public List<PlayDate> listMyPlayDates(int userId) {
        List<PlayDate> playDateList = new ArrayList<>();
        String sql = "SELECT p.playdate_id, dateandtime, location, requestmessage\n" +
                "FROM playdates as p\n" +
                "JOIN playdate_pet as pp ON pp.playdate_id =  p.playdate_id\n" +
                "JOIN user_pet as up ON pp.pet_id = up.pet_id\n" +
                "\tWHERE up.user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);

        while(result.next()) {
            playDateList.add(mapRowToPlayDate(result));
        }

        return playDateList;
    }



    @Override
    public PlayDate getPlayDateById(int playDateId) {
        PlayDate playDate = null;
        String sql = "SELECT playdate_id, dateandtime, location, requestmessage\n" +
                "\tFROM public.playdates WHERE playdate_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, playDateId);

        if (result.next()) {
            playDate = mapRowToPlayDate(result);
        }

        return playDate;
    }

    @Override
    public boolean schedulePlayDate(Timestamp dateAndTime, String location, String requestMessage){
        final String sql = " INSERT INTO playdates (dateandtime, location, requestmessage) " +
                " VALUES(?, ?, ?); ";
        return jdbcTemplate.update(sql, dateAndTime, location, requestMessage) == 1;
    }

    private PlayDate mapRowToPlayDate(SqlRowSet rowSet) {
        PlayDate playDate = new PlayDate();
        playDate.setPlayDateId(rowSet.getInt("playdate_id"));
        playDate.setDateAndTime(rowSet.getTimestamp("dateandtime"));
        playDate.setLocation(rowSet.getString("location"));
        playDate.setRequestMessage(rowSet.getString("requestmessage"));
        return playDate;
    }

}
