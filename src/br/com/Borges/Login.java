package br.com.Borges;

import Controller.UserController;
import java.sql.Connection;
import javax.swing.JFrame;

public class Login extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args, Connection conn) {

        UserController uc = new UserController(conn); 

    }
    
}
