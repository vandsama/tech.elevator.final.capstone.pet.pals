package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@CrossOrigin
public class PetController {

    private PetDao petDao;


    public PetController(PetDao petDao){
        this.petDao = petDao;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/pets/register", method = RequestMethod.POST)
    public void registerPet(@RequestBody Pet pet) {
        try {
            petDao.create(pet.getType(), pet.getName(), pet.isPet_experience(), pet.isVaccinated(), pet.isSpayed(), pet.getAge(), pet.getSex(), pet.getPet_friendliness(),pet.getHuman_friendliness(), pet.getActivities(),pet.getToy(),pet.getTreat(),pet.getImg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error creating pet");
        }
    }

}
