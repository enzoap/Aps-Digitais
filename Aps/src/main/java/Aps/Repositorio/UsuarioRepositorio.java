/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps.Repositorio;

import Aps.Database.DatabaseConnection;
import Aps.Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author enzoa
 */
public class UsuarioRepositorio {
    private Connection conn;
    
    public UsuarioRepositorio(){
        DatabaseConnection databaseConn = new DatabaseConnection();
        this.conn = databaseConn.connect();
    }
    
    public UsuarioModel getUser(String pName){
        String SQL = "select users.id, users.name ,password_fingerprint.path "
                    +"from users "
                    +"inner join password_fingerprint on users.id = password_fingerprint.user_id "
                    +"where  users.name  = ? " ;
        
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL);
            
            stmt.setString(1, pName);
            ResultSet rs = stmt.executeQuery();
            
            String name = "";
            String path = "";
            int id = 0;
            
            while(rs.next()){
                name = rs.getString("name");
                path = rs.getString("path");            
                id = Integer.parseInt(rs.getString("id"));
            }
            if(id == 0){
                System.out.println("Usuario nao encotrado no banco de dados");
                return null;
            }
            return new UsuarioModel(id, name, path);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            conn = null;
        }
        
        return null;
    }
   
    
    
}
