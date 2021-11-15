/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import logica.Juego;
import logica.Jugador;
import logica.Participante;
import logica.Sistema;

/**
 *
 * @author Gabriel
 */
public class LoginJugador extends LoginGenerico {

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public Object loginPolimorfico(String nombre, String contrasena) {
       Jugador usu=Sistema.getInstancia().loginJugador(nombre, contrasena);
       return usu;
    }

    @Override
    public void pantallaSiguiente(Object usu) {
       Juego j =Sistema.getInstancia().agregar((Jugador) usu);
       Participante p=j.buscar((Jugador) usu);
       new PartidaPoker(null,false,j,p).setVisible(true);
    }
    
}
