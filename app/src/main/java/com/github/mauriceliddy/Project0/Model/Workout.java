package com.github.mauriceliddy.Project0.Model;

public class Workout {

    private int wid;
    private String day;
    private int distance;
    private int gain;
    private double time;
    private Athlete athlete;

    public Workout(){

    }

    public Workout(int wid, String day, int distance, int gain, double time, Athlete athlete) {
        this.wid = wid;
        this.day = day;
        this.distance = distance;
        this.gain = gain;
        this.time = time;
        this.athlete = athlete;
    }

    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "Workout [athlete=" + athlete + ", day=" + day + ", distance=" + distance + ", gain=" + gain + ", time="
                + time + "]";
    }

    public void printWorkoutDataFromDB(){
        System.out.println("Workout:  [Workout ID: " +wid+ " athleteID: " + athlete.getId() + ", day=" + day + ", distance=" + distance + ", gain=" + gain + ", time="
        + time + "]");
    }
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    
    
}
