package com.example.hacksc_food;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Meal {
    private String cookName;
    private String mealName;
    private String description;
    private Date time;
    private String location;
    private int numPeople;
    private List<String> tags;

    public Meal(String mealName, String cookName, String description, Date time, String location, int numPeople, List<String> tags) {
        this.cookName = cookName;
        this.description = description;
        this.time = time;
        this.location = location;
        this.numPeople = numPeople;
        this.tags = tags;
        this.mealName = mealName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
