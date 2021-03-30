package com.github.mauriceliddy;

public class Workout {

    private String day;
    private int distance;
    private int gain;
    private double time;

    public Workout(){

    }

    public Workout(String day, int distance, int gain, double time) {
        this.day = day;
        this.distance = distance;
        this.gain = gain;
        this.time = time;
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

    @Override
    public String toString() {
        return "Workout{" +
                "day='" + day + '\'' +
                ", distance=" + distance +
                ", gain=" + gain +
                ", time=" + time +
                '}';
    }
}
