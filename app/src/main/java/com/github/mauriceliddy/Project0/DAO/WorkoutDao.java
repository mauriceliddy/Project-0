package com.github.mauriceliddy.Project0.DAO;
import com.github.mauriceliddy.Project0.Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDao implements DAO<Workout> {

    Connection connection;

    public WorkoutDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(Workout w) {
        try {
            PreparedStatement pStatement = connection.prepareStatement(
                    "insert into workouts (athlete_id,wout_day,distance,gain,wout_time) values(?,?,?,?,?)");
            pStatement.setInt(1, w.getAthlete().getId());
            pStatement.setString(2, w.getDay());
            pStatement.setInt(3, w.getDistance());
            pStatement.setInt(4, w.getGain());
            pStatement.setDouble(5, w.getTime());
            pStatement.execute();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Override
    public List<Workout> getAll() {

        List<Workout> masterList = new ArrayList<>();
        Workout workout=null;

        try {
            // Create statment
            Statement statement = connection.createStatement();
           ResultSet rSet = statement.executeQuery("select * from workouts");
            while (rSet.next()){
                workout = new Workout();
                Athlete athlete = new Athlete();
                workout.setWid(rSet.getInt("wid"));
                athlete.setId(rSet.getInt("athlete_id"));
                workout.setAthlete(athlete);
                workout.setDay(rSet.getString("wout_day"));
                workout.setDistance(rSet.getInt("distance"));
                workout.setGain(rSet.getInt("gain"));
                workout.setTime(rSet.getDouble("wout_time"));
                masterList.add(workout);
            }
            
        
        } catch (SQLException e) {
            //TODO: handle exception
        }
        return masterList;
       }

    @Override
    public void update(Workout e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Workout e) {

    }

    @Override
    public void clearTable() {
        try {
            PreparedStatement pStatement = connection.prepareStatement("delete from workouts");
            pStatement.execute();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

}
