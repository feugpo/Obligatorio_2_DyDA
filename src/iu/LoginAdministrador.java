/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import logica.Administrador;
import logica.PokerException;
import logica.Sistema;

/**
 *
 * @author Gabriel
 */
public class LoginAdministrador extends LoginGenerico {

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public Object loginPolimorfico(String nombre, String contrasena) throws PokerException {
        Administrador usu = Sistema.getInstancia().loginAdmin(nombre, contrasena);
        return usu;
    }

    @Override
    public void pantallaSiguiente(Object usu) {
        new MonitoreoJuegos(null, false, (Administrador) usu).setVisible(true);
    }

}
