/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps.Model;

/**
 *
 * @author enzoa
 */
public class UsuarioModel {
    private int Id;
    private String Name;
    private String Password_Fingerprint;

    public UsuarioModel() {
    }

    public UsuarioModel(int Id, String Name, String Password_Fingerprint) {
        this.Id = Id;
        this.Name = Name;
        this.Password_Fingerprint = Password_Fingerprint;
    }
    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword_Fingerprint() {
        return Password_Fingerprint;
    }

    public void setPassword_Fingerprint(String Password_Fingerprint) {
        this.Password_Fingerprint = Password_Fingerprint;
    }
    
}
