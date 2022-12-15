package com.techelevator.dao;

import com.techelevator.model.PlayDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlayDateDao implements PlayDateDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayDateDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<PlayDate> listAllPlayDates() {
        List<PlayDate> playDateList = new ArrayList<>();
        String sql = "SELECT playdate_id, creator_id, isCancelled, dateandtime, location, requestmessage\n" +
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
        String sql = "SELECT DISTINCT p.playdate_id, creator_id, isCancelled, dateandtime, location, requestmessage\n" +
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
        String sql = "SELECT playdate_id, creator_id, isCancelled, dateandtime, location, requestmessage\n" +
                "\tFROM public.playdates WHERE playdate_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, playDateId);

        if (result.next()) {
            playDate = mapRowToPlayDate(result);
        }

        return playDate;
    }

    @Override
    public int schedulePlayDate(int creatorId, LocalDateTime dateAndTime, String location, String requestMessage){
        final String sql = " WITH new_playdate AS (\n" +
                "INSERT INTO public.playdates(\n" +
                "\tcreator_id, dateandtime, location, requestmessage, iscancelled)\n" +
                "\tVALUES (?, ?, ?, ?, false)\n" +
                "\tRETURNING playdate_id)\n" +
                "\tSELECT playdate_id FROM new_playdate";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,creatorId,dateAndTime,location,requestMessage);
        int newId = 0;
        if (result.next()) {
            newId = result.getInt("playdate_id");
        }
        return newId;
    }

    @Override
    public void addPetsToPlaydate(int[] petIds, int playdateId) {
        String sql = "INSERT INTO playdate_pet(\n" +
                "\tplaydate_id, pet_id)\n" +
                "\tVALUES (?, ?);";

        for (int i = 0; i < petIds.length; i++) {
            jdbcTemplate.update(sql,playdateId, petIds[i]);
        }
    }

    @Override
    public void cancelPlaydate(int playdateId) {
        String sql = "UPDATE playdates\n" +
                "\tSET iscancelled=true\n" +
                "\tWHERE playdate_id = ?;";
        jdbcTemplate.update(sql, playdateId);
    }

    @Override
    public List<PlayDate> getPlaydatesUserCreated(int userId) {
        List<PlayDate> playDates = new ArrayList<>();
        String sql = "SELECT playdate_id, creator_id, dateandtime, location, requestmessage, iscancelled\n" +
                "\tFROM playdates\n" +
                "\tWHERE creator_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);

        while (result.next()) {
            PlayDate playDate = mapRowToPlayDate(result);
            playDates.add(playDate);
        }
        return playDates;
    }

    private PlayDate mapRowToPlayDate(SqlRowSet rowSet) {
        PlayDate playDate = new PlayDate();
        playDate.setCreatorId(rowSet.getInt("creator_id"));
        playDate.setCancelled(rowSet.getBoolean("isCancelled"));
        playDate.setPlayDateId(rowSet.getInt("playdate_id"));
        playDate.setDateAndTime(rowSet.getTimestamp("dateandTime").toLocalDateTime());
        playDate.setLocation(rowSet.getString("location"));
        playDate.setRequestMessage(rowSet.getString("requestmessage"));
        return playDate;
    }

}
