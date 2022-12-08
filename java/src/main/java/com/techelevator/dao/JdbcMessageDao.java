package com.techelevator.dao;

import com.techelevator.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMessageDao implements MessageDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMessageDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Message> listMessagesInTopic(int topicId) {
        List<Message> messageList = new ArrayList<>();
        String sql = "SELECT message_id, topic_id, message_title, message_text\n" +
                "\tFROM messages\n" +
                "\tWHERE topic_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,topicId);

        while (result.next()) {
            messageList.add(mapRowToMessage(result));
        }

        return messageList;
    }



    private Message mapRowToMessage(SqlRowSet rowSet) {
        Message message = new Message();
        message.setMessage_id(rowSet.getInt("message_id"));
        message.setTopic_id(rowSet.getInt("topic_id"));
        message.setText(rowSet.getString("message_text"));
        message.setTitle(rowSet.getString("message_title"));
        return message;
    }

}
