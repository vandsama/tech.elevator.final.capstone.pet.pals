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
        String sql = "SELECT message_id, user_id, topic_id, message_title, message_text\n" +
                "\tFROM messages\n" +
                "\tWHERE topic_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,topicId);

        while (result.next()) {
            messageList.add(mapRowToMessage(result));
        }

        return messageList;
    }

    @Override
    public boolean createMessage(int user_id, int topic_id, String message_text, String message_title) {
        String sql = "INSERT INTO messages(\n" +
                "\tuser_id, topic_id, message_title, message_text)\n" +
                "\tVALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sql, user_id, topic_id, message_title,message_text) == 1;
    }

    @Override
    public List<Message> searchMessageText(String text) {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages\n" +
                "WHERE message_text ILIKE '%' || ? || '%'";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, text);
        while (result.next()) {
            Message message = mapRowToMessage(result);
            messages.add(message);
        }

        return messages;
    }


    private Message mapRowToMessage(SqlRowSet rowSet) {
        Message message = new Message();
        message.setMessage_id(rowSet.getInt("message_id"));
        message.setUser_id(rowSet.getInt("user_id"));
        message.setTopic_id(rowSet.getInt("topic_id"));
        message.setText(rowSet.getString("message_text"));
        message.setTitle(rowSet.getString("message_title"));
        return message;
    }

}
