/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author enzoa
 */
public class DatabaseConnection {
    private  String database_connection_string = "jdbc:postgresql://localhost:5432/APS";
    private  String database_user_name = "postgres";
    private  String database_user_password = "123";
    
     /**

     * By using below code we are connecting to the database and returning the connection object.

     * @return 

    */
    public Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(database_connection_string, database_user_name, database_user_password );
                
            System.out.println("You are successfully connected to the PostgreSQL database server.");

        } catch (SQLException e) 

        {

            System.out.println(e.getMessage());

        }



        return conn;

    }


}
