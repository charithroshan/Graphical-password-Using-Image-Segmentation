/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class DBConnection {
    public static Connection c;
//    static Connection connectDB;
    public static Connection connectDB() {
    
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
           if(c==null)
           c = DriverManager.getConnection("jdbc:sqlite:puzzlepassword.db");
           
         return c;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     
    }
}

