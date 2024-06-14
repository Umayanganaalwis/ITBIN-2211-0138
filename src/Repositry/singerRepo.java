/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositry;

import Model.Singer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nayomal
 */
public class singerRepo {

    public static boolean update(Singer singer) throws SQLException {
  
         String query = "UPDATE singer SET singerName = ? WHERE singerId = ?";
            PreparedStatement pst = DB.MyConnection.con.prepareStatement(query);
            pst.setString(1, singer.getName());
            pst.setString(2, singer.getId());
             return pst.executeUpdate()>0;
    }

    public static ArrayList<Singer> getSingers() throws SQLException {
        
       ArrayList<Singer> list =  new ArrayList<>();
// Query to select all singers from the database
            String query = "SELECT * FROM singer";

            // Prepare the statement
            PreparedStatement pst = DB.MyConnection.con.prepareStatement(query);

            // Execute the query
            ResultSet rs = pst.executeQuery();
            
            
            while(rs.next()){
            
            list.add(new Singer(rs.getString(1),rs.getString(2)));
            
            
            
            }
            
            return list ;
            
    }

    public static boolean Save(Singer singer) throws SQLException {
                
        
            String query = "INSERT INTO singer (singerName) VALUES (?)";

                PreparedStatement pst = DB.MyConnection.con.prepareStatement(query);
                pst.setString(1, singer.getName()); // Set the value of the first parameter to singerName
                System.out.println("pst: " + pst);
               return pst.executeUpdate()>0;
    }

    public static boolean Delete(String id) throws SQLException {
                 String query = "DELETE FROM singer WHERE singerId = ?";
                PreparedStatement pst = DB.MyConnection.con.prepareStatement(query);
                pst.setString(1, id);
               return pst.executeUpdate()>0;   
    
    }
    
    
    
}
