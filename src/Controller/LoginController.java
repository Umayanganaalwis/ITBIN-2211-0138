/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author umaya
 */

import Model.User;
import Repositry.userRepo;
import View.LoginView;
import View.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {
    private User model;
    private LoginView view;
    public LoginController() {}

    public LoginController( LoginView view) {
      //  this.model = model;
        this.view = view;

        view.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });
    }

    public  void authenticateUser() {
        String email = view.getEmail();
        String password = view.getPassword();

         try { 
       boolean isCorrect =  userRepo.checkCredentials(new User(email,password));
        System.out.println("email"+email);
          if(isCorrect){
                
                      System.out.println("correct");
  
                HomeView obj = new HomeView();
                obj.show();
            }else{
                                    System.out.println("wrong");

                JOptionPane.showMessageDialog(null, "Email or Password is invalid try again");
                view.setEmail("");
                view.setPassword("");
            }
        
        
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in Login" +e);
        }
    }
}
