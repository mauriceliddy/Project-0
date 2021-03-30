package com.github.mauriceliddy;

import java.util.List;

public class Athlete {

    private String name;
    private int id;
    private List<Workout> workouts;

    public Athlete(){

    }
    public Athlete(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workouts=" + workouts +
                '}';
    }
}
