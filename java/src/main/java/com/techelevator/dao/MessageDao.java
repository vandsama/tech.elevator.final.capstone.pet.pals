package com.techelevator.dao;

import com.techelevator.model.Message;

import java.sql.Timestamp;

import java.util.List;

public interface MessageDao {
    List<Message> listMessagesInTopic(int topicId);

    boolean createMessage(Timestamp timestamp, int user_id, int topic_id, String message_text, String message_title);

    List<Message> searchMessageText(String text);
}
