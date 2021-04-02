package com.github.mauriceliddy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkoutDao implements DAO<Workout> {

    Connection connection;
    public WorkoutDao(Connection connection){
        this.connection= connection;
    }

    @Override
    public void insert(Workout e) {
    try {
        PreparedStatement pStatement = connection.
        prepareStatement("insert into workouts (aid,day,distance,gain,time) values(?,?,?,?,?)");
        
    } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }    
        
    }

    @Override
    public List<Workout> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Workout e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Workout e) {
        // TODO Auto-generated method stub
        
    }
    

    
}
