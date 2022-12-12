package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.dao.TopicDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Message;
import com.techelevator.model.Topic;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ForumController {

    private final MessageDao messageDao;
    private final TopicDao topicDao;
    private final UserDao userDao;

    public ForumController(MessageDao messageDao, TopicDao topicDao, UserDao userDao) {
        this.messageDao = messageDao;
        this.topicDao = topicDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> listTopics() {
        return topicDao.listTopics();
    }

//    @RequestMapping(value = "/topics/{id}/messages", method = RequestMethod.GET)
//    public List<Message> listMessages(@PathVariable int topicId) { return messageDao.listMessagesInTopic(topicId); }

    @RequestMapping(value = "/topics/create", method = RequestMethod.POST)
    public void createTopic(@RequestBody Topic topic, Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        int userId = user.getId();

        try {
            topicDao.createTopic(topic.getTitle());
            //TODO needs testing
            //not sure topic.getId() will actually return anything here
//            messageDao.createMessage(userId, topic.getId(), message.getText(), message.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating topic");
        }
    }

    @GetMapping(value = "topics/{id}")
    public Topic getTopicById(@PathVariable int id) {
        return topicDao.getTopicById(id);
    }

    @RequestMapping(value = "/topics/{id}/messages", method = RequestMethod.GET)
    public List<Message> listTopicMessages(@PathVariable int id) {
        return messageDao.listMessagesInTopic(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/topics/{topicId}/create", method = RequestMethod.POST)
    public void createMessage(Principal principal, @RequestBody Message message,
                              @PathVariable int topicId) {
        User user = userDao.findByUsername(principal.getName());
        int userId = user.getId();

        try {
            messageDao.createMessage(userId, topicId, message.getText(), message.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating message");
        }
    }


}
