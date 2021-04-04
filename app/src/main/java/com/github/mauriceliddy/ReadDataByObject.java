package com.github.mauriceliddy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDataByObject {
    
    
    public List<Athlete> readDataByObject(String filePath) {

        try {
            Scanner sc = new Scanner(new File(filePath));
            sc.useDelimiter(","); // sets the delimiter pattern as ','

            while (sc.hasNext()) {
                System.out.println("creating a new athlete");
                Athlete athlete = new Athlete();
                athlete.setName(sc.next());
                athlete.setId(Integer.parseInt(sc.next()));
                // System.out.println("athlete name: "+athlete.getName() );

                List<Workout> workouts = new ArrayList<>();
                while (sc.hasNext()) {
                    Workout workout = new Workout();
                    workout.setDay(sc.next().replaceAll("\\P{Print}", ""));// get rid of extra characters from .csv
                    workout.setDistance(Integer.parseInt(sc.next()));
                    workout.setGain(Integer.parseInt(sc.next()));
                    workout.setTime(Double.parseDouble(sc.next()));
                    workouts.add(workout);

                    if (sc.findInLine("end") != null) {
                        break;
                    }
                }

                //athlete.setWorkouts(workouts);
               // masterList.add(athlete);

            }
            sc.close(); // closes the scanner

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //return masterList;
        return null;
    }
}
