/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositry;

import Model.User;
import View.HomeView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nayomal
 */
public class userRepo {

    public static boolean checkCredentials(User user) throws SQLException {
            String query = "SELECT Email, Password FROM adminlogin WHERE Email = '" + user.getEmail() + "' AND Password = '" + user.getPassword() + "'";

            Statement st = DB.MyConnection.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("rs"+rs);
        
            if(rs.next()){
                return true;
            }else{
                
                return false;
    
            }
      
        
        
        
        
    }
    
    
    
    
    
}
