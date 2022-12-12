package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;

import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
public class PetController {

    private PetDao petDao;
    private UserDao userDao;


    public PetController(PetDao petDao, UserDao userDao){
        this.petDao = petDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/pets/register", method = RequestMethod.POST)
    public void registerPet(@RequestBody Pet pet, Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        int userId = user.getId();
        System.out.println(userId);

        try {
            petDao.create(pet.getType(), pet.getName(), pet.isPet_experience(), pet.isVaccinated(), pet.isSpayed(),
                    pet.getAge(), pet.getSex(), pet.getPet_friendliness(),pet.getHuman_friendliness(), pet.getActivities(),
                    pet.getToy(),pet.getTreat(),pet.getImg(), pet.getZipCode(),userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error creating pet");
        }
    }

    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable int id) {
        return petDao.getPetById(id);
    }
    @GetMapping("/pets")
    public List<Pet> viewAllPets(){
        return petDao.listAllPets();
    }

    @GetMapping("/pets/featured")
    public List<Pet> viewFeaturedPets(){return petDao.listFeaturedPets();}

//    @GetMapping("/users/{id}/pets")
//    public List<Pet> getUserPets(@PathVariable int id) {
//        return petDao.listPetsOwnedByUser(id);
//    }

}
