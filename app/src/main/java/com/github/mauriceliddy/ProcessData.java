package com.github.mauriceliddy;

import java.util.List;
import java.util.Scanner;

public class ProcessData {

    int distance = 0;
    int gain = 0;
    double time = 0;
    String workoutType = "";
    Scanner scan = new Scanner(System.in);
    List<Athlete> masterList;

    public ProcessData(List<Athlete> masterList) {
        this.masterList = masterList;
    }

    /**
     * 
     * @param day
     * @param choice
     */
    public void processChoice(String day, int choice) {
        switch (choice) {
        case 1:
            System.out.println("How far do you want to run?");
            distance = scan.nextInt();
            workoutType = "distance";
            break;
        case 2:
            System.out.println("How much vertical gain do you want?");
            gain = scan.nextInt();
            workoutType = "gain";
            break;
        case 3:
            System.out.println("How much time do you want to run for in hours?");
            time = scan.nextDouble();
            workoutType = "time";
            break;
        }
        findWorkout(workoutType, day,distance,gain,time);
    }

    /**
     *
     * @param workoutType
     * @param day
     */
    public boolean findWorkout(String workoutType, String day,int distance,int gain,double time) {

        boolean workoutFound = false;
        for (Athlete athlete : masterList) {
            for (Workout workout : athlete.getWorkouts()) {

                switch (workoutType) {
                case "distance":
                    if (workout.getDistance() == distance && workout.getDay().equals(day)) {
                        System.out.println("We found a workout, you should run with: " + athlete.getName() + " on "
                                + workout.getDay());
                        workoutFound = true;
                    }
                    break;
                case "gain":
                    if (workout.getGain() == gain && workout.getDay().equals(day)) {
                        System.out.println("We found a workout, you should run with: " + athlete.getName() + " on "
                                + workout.getDay());
                        workoutFound = true;
                    }
                    break;
                case "time":
                    if (workout.getTime() == time && workout.getDay().equals(day)) {
                        System.out.println("We found a workout, you should run with: " + athlete.getName() + " on "
                                + workout.getDay());
                        workoutFound = true;
                    }
                    break;
                }
            }
        }
        if (!workoutFound) {
            System.out.println("Sorry, no one to run with this week..");
        }
        return workoutFound;

    }
}
