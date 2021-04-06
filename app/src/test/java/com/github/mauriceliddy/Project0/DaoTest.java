package com.github.mauriceliddy.Project0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.github.mauriceliddy.Project0.DAO.WorkoutDao;
import com.github.mauriceliddy.Project0.DataManagement.*;
import com.github.mauriceliddy.Project0.Model.*;

import org.junit.jupiter.api.Test;

public class DaoTest {

  @Test
  public void testAthleteGetAll() {

    DataInput dataInput = new DataInput();
    List<Workout> masterList = dataInput.readInData();
    UserDatabaseAccess uAccess = new UserDatabaseAccess();
    uAccess.sendCSVDataToDatabase(masterList);
    List<Athlete> athleteListFromDB = new ArrayList<>();
    athleteListFromDB = uAccess.retrieveAthletesFromDb();
    assertEquals(4, athleteListFromDB.size());

  }

  @Test
  public void testWorkoutGetAll() {

    DataInput dataInput = new DataInput();
    List<Workout> masterList = dataInput.readInData();
    UserDatabaseAccess uAccess = new UserDatabaseAccess();
    uAccess.sendCSVDataToDatabase(masterList);
    List<Workout> workoutListFromDB = new ArrayList<>();
    workoutListFromDB = uAccess.retrieveAllFromDb();
    assertEquals(20, workoutListFromDB.size());

  }
}
