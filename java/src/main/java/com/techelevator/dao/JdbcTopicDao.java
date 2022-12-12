package com.techelevator.dao;

import com.techelevator.model.Topic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTopicDao implements TopicDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTopicDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Topic> listTopics() {
        List<Topic> topics = new ArrayList<>();

        String sql = "SELECT topic_id, topic_title\n" +
                "\tFROM topics;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Topic topic = mapRowToTopic(result);
            topics.add(topic);
        }

        return topics;
    }

    @Override
    public boolean createTopic(String topicTitle) {
        String sql = "INSERT INTO topics(\n" +
                "\ttopic_title)\n" +
                "\tVALUES (?);";

        return jdbcTemplate.update(sql,topicTitle) == 1;
    }

    @Override
    public Topic getTopicById(int id) {
        Topic topic = new Topic();
        String sql = "SELECT * FROM topics WHERE topic_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            topic = mapRowToTopic(result);
        }

        return topic;
    }

    private Topic mapRowToTopic(SqlRowSet rowSet) {
        Topic topic = new Topic();
        topic.setId(rowSet.getInt("topic_id"));
        topic.setTitle(rowSet.getString("topic_title"));
        return topic;
    }

}
