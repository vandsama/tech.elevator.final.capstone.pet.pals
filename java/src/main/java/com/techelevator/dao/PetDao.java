package com.techelevator.dao;

public interface PetDao {

    boolean create(String type, String name, boolean pet_experience, boolean vaccinated, boolean spayed, String age, String sex, String pet_friendliness, String human_friendliness, String activities, String toy, String treat, String img);

}
