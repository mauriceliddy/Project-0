package com.github.mauriceliddy;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class UserDatabaseAccess {
    Properties properties = new Properties();

    public void sendCSVDataToDatabase(List<Workout> masterList) {
        // Read in DB data from Properties file
       
        try {
            FileInputStream fileStream = new FileInputStream("app/database.properties");
            properties.load(fileStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        String url = properties.getProperty("URL");
        String password = properties.getProperty("CONNECTION_PASSWORD");
        String username = properties.getProperty("CONNECTION_USERNAME");

        try {
            System.out.println("Opening connection to the database...");
            Connection connection = DriverManager.getConnection(url, username, password);
            AthleteDao athleteDao = new AthleteDao(connection);
            WorkoutDao wDao = new WorkoutDao(connection);

            // Erase data from database first
            wDao.clearTable();
            athleteDao.clearTable();

            // Extract Athletes from masterlist and send to database to populate athlete
            // table first
            // Use set because I want to ignore any repeats
            Set<Athlete> masterAthleteSet = new HashSet<>();
            for (Workout wout : masterList) {
                masterAthleteSet.add(wout.getAthlete());
            }

            // Insert each Athlete into the database
            // insertAth() method returns the athlete so we can update the Athlete ID in the
            // model
            // based on value assigned by database
            Set<Athlete> newSet = new HashSet<>();
            for (Athlete ath : masterAthleteSet) {
                ath = athleteDao.insertAth(ath); // insert into DB
                newSet.add(ath); // add that Athlete with updated ID to Set for use later
            }

            // For each workout, set the athlete ID in the masterLst to match the athlete id from the database
            for (Workout wout : masterList) {
                for (Athlete ath : newSet) {
                    if (ath.getName().equals(wout.getAthlete().getName())) {
                        wout.getAthlete().setId(ath.getId());
                    }
                }
            }

            // Finally, since the Athlete Ids are all fixed we can insert each workout into the database accurately
            // with no existing value errors
            for (Workout wout : masterList) {
                wDao.insert(wout);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Workout> retrieveAllFromDb(){
        List<Workout> workoutsFromDB = new ArrayList<>();
        String url = properties.getProperty("URL");
        String password = properties.getProperty("CONNECTION_PASSWORD");
        String username = properties.getProperty("CONNECTION_USERNAME");

        try {
            System.out.println("Opening connection to the database...");
            Connection connection = DriverManager.getConnection(url, username, password);
            WorkoutDao wDao = new WorkoutDao(connection);
            workoutsFromDB= wDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return workoutsFromDB;
    }

}
