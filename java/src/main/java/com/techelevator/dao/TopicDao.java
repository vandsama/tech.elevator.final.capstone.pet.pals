package com.techelevator.dao;

import com.techelevator.model.Topic;
import java.sql.Timestamp;

import java.util.List;

public interface TopicDao {
    List<Topic> listTopics();

    boolean createTopic(Timestamp timestamp, String topicTitle);

    Topic getTopicById(int id);
}
