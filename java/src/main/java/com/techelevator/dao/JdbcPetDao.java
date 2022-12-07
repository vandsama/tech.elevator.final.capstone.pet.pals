package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public boolean create(String type, String name, boolean pet_experience, boolean vaccinated, boolean spayed, String age, String sex, String pet_friendliness, String human_friendliness, String activities, String toy, String treat, String img,int userId) {
        String insertPetSql = "WITH new_pet AS (\n" +
                "INSERT INTO pets(\n" +
                "\tanimal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id)\n" +
                "\tINSERT INTO user_pet(\n" +
                "\tuser_id, pet_id)\n" +
                "\tVALUES (?, (SELECT pet_id FROM new_pet));";

        return jdbcTemplate.update(insertPetSql,type,name,pet_experience,vaccinated,spayed,age,sex,pet_experience,human_friendliness,activities,toy,treat,img,userId) == 1;
    }

}
