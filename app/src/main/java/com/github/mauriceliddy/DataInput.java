package com.github.mauriceliddy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataInput {
    List<Workout> masterList = new ArrayList<>();

    public List<Workout> readInData() {
        try {
            Scanner sc = new Scanner(new File("data.csv"));
            sc.useDelimiter(","); // sets the delimiter pattern
            while (sc.hasNext()) // returns a boolean value
            {
                Athlete athlete = new Athlete();
                athlete.setName(sc.next().replaceAll("\\P{Print}", ""));
                athlete.setId(Integer.parseInt(sc.next()));
                Workout workout = new Workout();
                workout.setDay(sc.next());
                workout.setDistance(Integer.parseInt(sc.next()));
                workout.setGain(Integer.parseInt(sc.next()));
                workout.setTime(Double.parseDouble(sc.next()));
                workout.setAthlete(athlete);
                masterList.add(workout);
            }
            sc.close(); // closes the scanner

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return masterList;
    }

}
