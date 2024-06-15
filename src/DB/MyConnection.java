/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author umaya
 */
public class MyConnection {
    
    public static Connection con;
    
    MyConnection(){
    loadConnection();
    }
    
    public static void loadConnection(){
        String url = "jdbc:mysql://localhost:3306/tune_wave";
        String userName = "root";
        String pass = "1234";
        
        try{
            con = DriverManager.getConnection(url, userName, pass);
            if(con != null){
                JOptionPane.showMessageDialog(null,"DB Loaded");
            } else {
                JOptionPane.showMessageDialog(null, "Driver not loaded...");
            }
        } catch (SQLException e) {
            System.out.println("ima");
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
