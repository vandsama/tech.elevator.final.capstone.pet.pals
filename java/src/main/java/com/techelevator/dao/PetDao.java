package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {

    boolean create(String type, String name, boolean pet_experience, boolean vaccinated, boolean spayed, String age, String sex, String pet_friendliness, String human_friendliness, String activities, String toy, String treat, String img, String zipCode, int userId);

    Pet getPetById(int id);

    List<Pet> listAllPets();

    List<Pet> listPetsOwnedByUser(int userId);

    List<Pet> listPetsAttendingPlaydate(int playdateId);

    List<Pet> listFeaturedPets();
}
