package com.techelevator.model;

public class Pet {

    private int id;
    private String type;
    private String name;
    private boolean pet_experience;
    private boolean vaccinated;
    private boolean spayed;
    private String age;
    private String sex;
    private  String pet_friendliness;
    private  String human_friendliness;
    private String activities;
    private String toy;
    private String treat;
    private String img;

    public Pet(int id, String type, String name, boolean pet_experience, boolean vaccinated, boolean spayed, String age, String sex, String pet_friendliness, String human_friendliness, String activities, String toy, String treat, String img) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.pet_experience = pet_experience;
        this.vaccinated = vaccinated;
        this.spayed = spayed;
        this.age = age;
        this.sex = sex;
        this.pet_friendliness = pet_friendliness;
        this.human_friendliness = human_friendliness;
        this.activities = activities;
        this.toy = toy;
        this.treat = treat;
        this.img = img;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPet_experience() {
        return pet_experience;
    }

    public void setPet_experience(boolean pet_experience) {
        this.pet_experience = pet_experience;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isSpayed() {
        return spayed;
    }

    public void setSpayed(boolean spayed) {
        this.spayed = spayed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPet_friendliness() {
        return pet_friendliness;
    }

    public void setPet_friendliness(String pet_friendliness) {
        this.pet_friendliness = pet_friendliness;
    }

    public String getHuman_friendliness() {
        return human_friendliness;
    }

    public void setHuman_friendliness(String human_friendliness) {
        this.human_friendliness = human_friendliness;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
