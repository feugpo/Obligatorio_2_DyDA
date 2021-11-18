/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import javax.swing.JOptionPane;
import logica.Juego;
import logica.Jugador;
import logica.Participante;
import logica.PokerException;
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
    public Object loginPolimorfico(String nombre, String contrasena) throws PokerException {
        Jugador usu = Sistema.getInstancia().loginJugador(nombre, contrasena);
        return usu;
    }

    @Override
    public void pantallaSiguiente(Object usu) {
        try{
            Juego j = Sistema.getInstancia().agregar((Jugador) usu);
            Participante p = j.buscar((Jugador) usu);
            mostrarError("");
            new PartidaPoker(null, false, j, p).setVisible(true);
        }catch(PokerException ex){
            mostrarError(ex.getMessage());
        }
    }

}
