package com.techelevator.dao;

import com.techelevator.model.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> listTopics();

    boolean createTopic(String topicTitle);

    Topic getTopicById(int id);
}
