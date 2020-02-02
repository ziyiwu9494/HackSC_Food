package com.example.hacksc_food;
import android.location.Location;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Meal {
    private String key;
    private String cookName;
    private String mealName;
    private String description;
    private String time;
    private String location;
    private int numPeople;
    private List<String> tags;
    private Map<String,String> attendees;

    public Meal(String mealName, String cookName, String description, String time, String location, int numPeople, List<String> tags) {
        this.cookName = cookName;
        this.description = description;
        this.time = time;
        this.location = location;
        this.numPeople = numPeople;
        this.tags = tags;
        this.mealName = mealName;
    }
    public Meal(){
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public Map<String,String> getAttendees() {
        return attendees;
    }

    public void setAttendees(Map<String,String> attendees) {
        this.attendees = attendees;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
