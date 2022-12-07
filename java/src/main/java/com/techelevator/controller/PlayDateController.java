package com.techelevator.controller;

import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;
import com.techelevator.dao.PlayDateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.PlayDate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RMIClassLoader;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class PlayDateController {

    private PlayDateDao playDateDao;
    private UserDao userDao;

    public PlayDateController(PlayDateDao playDateDao, UserDao userDao) {
        this.playDateDao = playDateDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/playdates", method = RequestMethod.GET)
    public List<PlayDate> viewPlayDates(Principal principal) {
        return playDateDao.listAllPlayDates();
    }

    @GetMapping("/playdates/{playdate_id}")
    public PlayDate getPlayDateById(@PathVariable int playDateId) {
        return this.playDateDao.getPlayDateById(playDateId);
    }


}
