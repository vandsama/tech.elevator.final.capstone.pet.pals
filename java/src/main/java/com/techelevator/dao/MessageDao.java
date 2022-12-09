package com.techelevator.dao;

import com.techelevator.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> listMessagesInTopic(int topicId);

    boolean createMessage(int user_id, int topic_id, String message_text, String message_title);
}
