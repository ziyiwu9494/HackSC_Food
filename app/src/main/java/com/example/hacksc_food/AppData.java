package com.example.hacksc_food;

import android.app.Application;
import android.view.Menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppData extends Application {
    private Set<String> claimedMeals = new HashSet<String>();
    private List<Meal> allMeals = new ArrayList<Meal>();

    public Set<String> getClaimedMeals() {
        return claimedMeals;
    }

    public void setClaimedMeals(Set<String> claimedMeals) {
        this.claimedMeals = claimedMeals;
    }

    public List<Meal> getAllMeals() {
        return allMeals;
    }

    public void setAllMeals(List<Meal> allMeals) {
        this.allMeals = allMeals;
    }
}
