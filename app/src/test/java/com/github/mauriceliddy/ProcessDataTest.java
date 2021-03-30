package com.github.mauriceliddy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ProcessDataTest {

    // Set up Class with a Dummy Athlete and workout data
    Athlete athlete = new Athlete("Maurice", 1);
    Workout workout = new Workout("Monday", 10, 4000, 5);
    List<Workout> workouts = new ArrayList<>();
    List<Athlete> masterList = new ArrayList<>();

    // Test findWorkout() to see if it will return a true when a workout is found
    @Test
    void testCorrectRunFound() {
        workouts.add(workout);
        athlete.setWorkouts(workouts);
        masterList.add(athlete);
        ProcessData processData = new ProcessData(masterList);
        boolean result = processData.findWorkout("distance", "Monday", 10, 4000, 5);
        assertEquals(result, true);
    }

    // Test findWorkout() to see if it will return a false when a workout is not
    // found
    @Test
    void testNoRunFound() {
        workouts.add(workout);
        athlete.setWorkouts(workouts);
        masterList.add(athlete);
        ProcessData processData = new ProcessData(masterList);
        boolean result = processData.findWorkout("distance", "Monday", 11, 4000, 5);
        assertEquals(result, false);
    }

}
