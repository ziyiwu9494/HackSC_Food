package com.example.hacksc_food;

import java.util.Set;

public class Meal {
    private String cookName;
    private String description;
    private int timeHour;
    private int timeMinute;
    private String location;
    private int numPeople;
    private Set<String> tags;

    public Meal(String cookName, String description, int timeHour,
                int timeMinute, String location, int numPeople, Set<String> tags) {
        this.cookName = cookName;
        this.description = description;
        this.timeHour = timeHour;
        this.timeMinute = timeMinute;
        this.location = location;
        this.numPeople = numPeople;
        this.tags = tags;
    }
}
