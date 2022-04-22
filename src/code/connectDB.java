/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class connectDB {
    
    public Connection con;
    
        public Connection dbConnection()
{
    try
    {
    Class.forName("org.sqlite.JDBC").newInstance();
    con= DriverManager.getConnection("jdbc:sqlite:graphicalpassword.db");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return con;
}
    
}
