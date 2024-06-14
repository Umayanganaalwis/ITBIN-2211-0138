/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nayomal
 */


import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean authenticate() {
        try {
            String query = "SELECT Email, Password FROM adminlogin WHERE Email = '" + email + "' AND Password = '" + password + "'";
            Statement st = DB.MyConnection.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

