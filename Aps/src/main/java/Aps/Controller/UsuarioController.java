/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps.Controller;

import Aps.Model.UsuarioModel;
import Aps.Repositorio.UsuarioRepositorio;

/**
 *
 * @author enzoa
 */
public class UsuarioController {
    private UsuarioRepositorio oUsuarioRepositorio;
    
    public UsuarioController(){
        oUsuarioRepositorio = new UsuarioRepositorio();
    }

    public UsuarioModel getUser(String pName){
        
        UsuarioModel usuario = oUsuarioRepositorio.getUser(pName);
        return usuario;
    }
}
