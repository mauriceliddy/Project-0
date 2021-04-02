package com.github.mauriceliddy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AthleteDao implements DAO<Athlete>{

    Connection connection;
    public AthleteDao(Connection connection){
        this.connection = connection;

    }

    @Override
    public void insert(Athlete ath) {
        PreparedStatement pStatement;
        try {
            pStatement = connection.prepareStatement("insert into athletes (aname) values(?)", Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, ath.getName());
            pStatement.execute();
            ResultSet rSet = pStatement.getGeneratedKeys();
            if(rSet.next()){
                ath.setId(rSet.getInt(1));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

    @Override
    public List<Athlete> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Athlete e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Athlete e) {
        // TODO Auto-generated method stub
        
    }
    
   
    
}
