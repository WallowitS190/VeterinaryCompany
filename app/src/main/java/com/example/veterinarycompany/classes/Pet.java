package com.example.veterinarycompany.classes;

public class Pet {
    private String name, race, sex;
    private int id, age, owner;

    public Pet() {}

    public Pet(String name, int age, String race, String sex, int owner) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.sex = sex;
        this.owner = owner;
    }
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
