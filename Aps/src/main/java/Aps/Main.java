/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps;

import Aps.Controller.UsuarioController;
import Aps.Model.UsuarioModel;
import Aps.Utils.FingerPrintRecognition;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enzoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
       FingerPrintRecognition finger = new FingerPrintRecognition();
        try {
            finger.setPath("../impressoes/user_enzo.png");
            UsuarioController usuarioController = new UsuarioController();
            UsuarioModel usuario = usuarioController.getUser("Enzo");
            boolean eIgual = finger.isMatch(usuario);
            if(eIgual){
                System.out.println("Bem vindo "+usuario.getName());
            }else {
                System.out.println("Senha errada, tente novamente");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

}
