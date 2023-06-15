package com.sherdog.FightersRanking.domain;

import jakarta.persistence.*;
;

@Entity
@Table(name = "fighters")
public class fighters {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String nickName ;
    private int age;
    private int height;
    private int yearsOfExperience;
    private int fights;
   private boolean championships;
    private String record;
    private Integer weight;

    public fighters(){}

    public fighters(Long id, String name, String lastName, String nickName, int age, int height, int yearsOfExperience, int fights, boolean championships, String record,Integer weight) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.height = height;
        this.yearsOfExperience = yearsOfExperience;
        this.fights = fights;
        this.championships = championships;
        this.record = record;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {return weight;}

    public void setWeight(Integer weight) {this.weight = weight;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getFights() {
        return fights;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public boolean isChampionships() {
        return championships;
    }

    public void setChampionships(boolean championships) {
        this.championships = championships;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}

