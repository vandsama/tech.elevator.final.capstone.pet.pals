package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.PlayDateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PlayDate;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.Timestamp;

import java.util.List;

@RestController
@CrossOrigin
public class PlayDateController {

    private PlayDateDao playDateDao;
    private UserDao userDao;
    private PetDao petDao;

    public PlayDateController(PlayDateDao playDateDao, UserDao userDao, PetDao petDao) {
        this.playDateDao = playDateDao;
        this.userDao = userDao;
        this.petDao = petDao;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/playdates", method = RequestMethod.GET)
    public List<PlayDate> viewAllPlayDates() {
        return playDateDao.listAllPlayDates();
    }

    //TODO better mapping?
    @GetMapping(value = "/myplaydates")
    public List<PlayDate> viewOwnPlayDates(Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        return playDateDao.listMyPlayDates(user.getId());
    }

    @GetMapping("/playdates/{playdateId}")
    public PlayDate getPlayDateById(@PathVariable int playdateId) {
        return this.playDateDao.getPlayDateById(playdateId);
    }

    @GetMapping("playdates/{playdateId}/pets")
    public List<Pet> getPetsAttendingPlaydate(@PathVariable int playdateId) {
        return this.petDao.listPetsAttendingPlaydate(playdateId);
    }

    @GetMapping("/playdates/{playdateId}/users")
    public List<User> getUsersAttendingPlaydate(@PathVariable int playdateId) {
        List<User> users = this.userDao.listUsersAttendingPlaydate(playdateId);
        for (User user : users) {
            user.setPets(petDao.listPetsAttendingPlaydate(playdateId,user.getId()));
        }
        return users;
    }

    @RequestMapping(value = "/playdates/schedule", method = RequestMethod.POST)
    public int createPlayDate(@RequestBody PlayDate playDate, Principal principal){
        User user = userDao.findByUsername(principal.getName());
        int userId = user.getId();

        try {
            return playDateDao.schedulePlayDate(userId, playDate.getDateAndTime(), playDate.getLocation(), playDate.getRequestMessage());
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error Scheduling Play Date");
        }
    }

    @RequestMapping(value = "/playdates/{playdateId}/join", method = RequestMethod.POST)
    public void joinPlaydate(@PathVariable int playdateId, @RequestBody int[] petIds) {
        try {
            playDateDao.addPetsToPlaydate(petIds, playdateId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error adding pets to playdate");
        }
    }

    @RequestMapping(value = "/playdates/{playdateId}/cancel", method = RequestMethod.PUT)
    public void cancelPlaydate(@PathVariable int playdateId, Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        int userId = user.getId();
        PlayDate playDate = playDateDao.getPlayDateById(playdateId);

        if (playDate.getCreatorId() != userId) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cannot cancel playdates you did not create");
        }

        if (playDate.isCancelled()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Playdate already cancelled");
        }

        try {
            playDateDao.cancelPlaydate(playdateId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error cancelling playdate");
        }
    }

    @GetMapping(value = "/playdates/user/{userId}")
    public List<PlayDate> getPlaydatesUserCreated(@PathVariable int userId) {
        return playDateDao.getPlaydatesUserCreated(userId);
    }


}
