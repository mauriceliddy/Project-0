package com.github.mauriceliddy.Project0.DataManagement;
import com.github.mauriceliddy.Project0.Model.*;
import com.github.mauriceliddy.Project0.DAO.*;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDatabaseAccess {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties = new Properties();
    Connection connection;
    String url;
    String password;
    String username;
    WorkoutDao wDao;
    AthleteDao aDao;

    public void accessDatabase() {
        try {
            FileInputStream fileStream = new FileInputStream("C:/VSCode Programs/Week1/Project-0/app/database.properties");
            properties.load(fileStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        url = properties.getProperty("URL");
        password = properties.getProperty("CONNECTION_PASSWORD");
        username = properties.getProperty("CONNECTION_USERNAME");

        try {
            logger.info("Opening connection to the database...");
            connection = DriverManager.getConnection(url, username, password);
            aDao= new AthleteDao(connection);
            wDao = new WorkoutDao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sendCSVDataToDatabase(List<Workout> masterList) {
        accessDatabase();

        // Erase data from database first
        clearAllTables();

        // Extract Athletes from masterlist and send to database to populate athlete
        // table first
        // Use set because I want to ignore any repeats
        Set<Athlete> masterAthleteSet = new HashSet<>();
        for (Workout wout : masterList) {
            masterAthleteSet.add(wout.getAthlete());
        }

        // Insert each Athlete into the database
        // insertAth() method returns the athlete so we can update the Athlete ID in the
        // model based on value assigned by database
        Set<Athlete> newSet = new HashSet<>();
        for (Athlete ath : masterAthleteSet) {
            ath = aDao.insertAth(ath); // insert into DB
            newSet.add(ath); // add that Athlete with updated ID to Set for use later
        }

        // For each workout, set the athlete ID in the masterLst to match the athlete id
        // from the database
        for (Workout wout : masterList) {
            for (Athlete ath : newSet) {
                if (ath.getName().equals(wout.getAthlete().getName())) {
                    wout.getAthlete().setId(ath.getId());
                }
            }
        }

        // Finally, since the Athlete Ids are all fixed we can insert each workout into
        // the database accurately with no existing value errors
        for (Workout wout : masterList) {
            wDao.insert(wout);
        }
    }

    public List<Workout> retrieveAllFromDb() {
        List<Workout> workoutsFromDB = new ArrayList<>();
        accessDatabase();
        workoutsFromDB = wDao.getAll();
        return workoutsFromDB;
    }

    public List<Athlete> retrieveAthletesFromDb(){
        List<Athlete> athletesFromDB = new ArrayList<>();
        accessDatabase();
        athletesFromDB =  aDao.getAll();
        return athletesFromDB;
    }

    public void clearAllTables(){
        accessDatabase();
        wDao.clearTable();
        aDao.clearTable();
    }

}
