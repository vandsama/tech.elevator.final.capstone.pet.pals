package com.techelevator.dao;

import com.techelevator.model.PlayDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlayDateDao implements PlayDateDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayDateDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<PlayDate> listAllPlayDates() {
        List<PlayDate> playDateList = new ArrayList<>();
        String sql = "SELECT playdate_id, dateandtime, location, requestmessage, inviter_user_id, inviter_pet_id, invitee_user_id, invitee_pet_id\n" +
                "\tFROM public.playdates;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()) {
            playDateList.add(mapRowToPlayDate(result));
        }

        return playDateList;
    }

    @Override
    public PlayDate getPlayDateById(int playDateId) {
        PlayDate playDate = null;
        String sql = "SELECT playdate_id, dateandtime, location, requestmessage, inviter_user_id, inviter_pet_id, invitee_user_id, invitee_pet_id\n" +
                "\tFROM public.playdates WHERE playdate_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, playDateId);

        if (result.next()) {
            playDate = mapRowToPlayDate(result);
        }

        return playDate;
    }

    private PlayDate mapRowToPlayDate(SqlRowSet rowSet) {
        PlayDate playDate = new PlayDate();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E MM dd yyyy H:m");
        playDate.setInviteePetId(rowSet.getInt("invitee_pet_id"));
        playDate.setInviterPetId(rowSet.getInt("inviter_pet_id"));
        playDate.setInviteeUserId(rowSet.getInt("invitee_user_id"));
        playDate.setInviterUserId(rowSet.getInt("inviter_user_id"));
        playDate.setLocation(rowSet.getString("location"));
        playDate.setPlayDateId(rowSet.getInt("playdate_id"));
        playDate.setRequestMessage(rowSet.getString("requestmessage"));
        playDate.setTimestamp(rowSet.getTimestamp("dateandtime"));
        return playDate;
    }

//    @Override
//    public boolean createPlayDate()


}
