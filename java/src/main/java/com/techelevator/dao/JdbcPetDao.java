package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public boolean create(String type, String name, boolean pet_experience, boolean vaccinated, boolean spayed, String age, String sex, String pet_friendliness, String human_friendliness, String activities, String toy, String treat, String img, String zipCode, int userId) {
        String insertPetSql = "WITH new_pet AS (\n" +
                "INSERT INTO pets(\n" +
                "\tanimal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?) RETURNING pet_id)\n" +
                "\tINSERT INTO user_pet(\n" +
                "\tuser_id, pet_id)\n" +
                "\tVALUES (?, (SELECT pet_id FROM new_pet));";

        return jdbcTemplate.update(insertPetSql,type,name,pet_experience,vaccinated,spayed,age,sex,pet_experience,human_friendliness,activities,toy,treat,img, zipCode, userId) == 1;
    }

    @Override
    public Pet getPetById(int id) {
        Pet pet = null;
        String sql = "SELECT pet_id, animal_type, pet_name, pet_experience, vaccinated, spayed," +
                " age_years, sex, pet_friendliness, human_friendliness, favorite_activities," +
                " favorite_toy, favorite_treat, img_link, zip_code\n" +
                "\tFROM pets\n" +
                "\tWHERE pet_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);

        if (result.next()) {
            pet = mapRowToPet(result);

        }

        return pet;
    }
    @Override
    public List<Pet> listAllPets(){
        List<Pet> petList = new ArrayList<>();
        String sql = "SELECT pet_id, animal_type, pet_name, pet_experience, vaccinated, spayed," +
        " age_years, sex, pet_friendliness, human_friendliness, favorite_activities," +
                " favorite_toy, favorite_treat, img_link, zip_code\n" +
                "\tFROM pets\n;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            petList.add(mapRowToPet(result));
        }
        return petList;
    }
    @Override
    public List<Pet>listFeaturedPets(){
        List<Pet> petList = new ArrayList<>();
        String sql = "SELECT pet_id, animal_type, pet_name, pet_experience, vaccinated, spayed," +
                " age_years, sex, pet_friendliness, human_friendliness, favorite_activities," +
                " favorite_toy, favorite_treat, img_link, zip_code\n" +
                "\tFROM pets\n" +
                "LIMIT 4;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            petList.add(mapRowToPet(result));
        }
        return petList;
    }

    @Override
    public List<Pet> listPetsOwnedByUser(int userId) {
        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT p.pet_id, animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code\n" +
                "\tFROM pets AS p\n" +
                "\tJOIN user_pet AS up ON p.pet_id = up.pet_id\n" +
                "\tWHERE up.user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);
        while(result.next()){
            pets.add(mapRowToPet(result));
        }
        return pets;
    }

    @Override
    public List<Pet> listPetsAttendingPlaydate(int playdateId) {
        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT p.pet_id, animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code\n" +
                "\tFROM pets AS p\n" +
                "\tJOIN playdate_pet AS pp ON p.pet_id = pp.pet_id\n" +
                "\tWHERE playdate_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,playdateId);
        while(result.next()){
            pets.add(mapRowToPet(result));
        }

        return pets;
    }

    public Pet mapRowToPet(SqlRowSet rowSet) {
        Pet pet = new Pet();
        pet.setId(rowSet.getInt("pet_id"));
        pet.setType(rowSet.getString("animal_type"));
        pet.setName(rowSet.getString("pet_name"));
        pet.setPet_experience(rowSet.getBoolean("pet_experience"));
        pet.setVaccinated(rowSet.getBoolean("vaccinated"));
        pet.setSpayed(rowSet.getBoolean("spayed"));
        pet.setAge(rowSet.getString("age_years"));
        pet.setSex(rowSet.getString("sex"));
        pet.setPet_friendliness(rowSet.getString("pet_friendliness"));
        pet.setHuman_friendliness(rowSet.getString("human_friendliness"));
        pet.setActivities(rowSet.getString("favorite_activities"));
        pet.setToy(rowSet.getString("favorite_toy"));
        pet.setTreat(rowSet.getString("favorite_treat"));
        pet.setImg(rowSet.getString("img_link"));
        pet.setZipCode(rowSet.getString("zip_code"));
        return pet;
    }



}
