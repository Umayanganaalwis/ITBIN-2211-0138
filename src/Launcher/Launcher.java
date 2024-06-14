/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launcher;
import Model.User;
import View.LoginView;
import Controller.LoginController;

import DB.MyConnection;
import View.LoginJFrame;
import java.awt.Frame;
public class Launcher {
public static LoginView root;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        root = new LoginView();
        root.show(true);
        
//       root = new LoginJFrame();
//        root.setLocationRelativeTo(null);
//        root.show();
        
        
        MyConnection.loadConnection();
    }
    
}
