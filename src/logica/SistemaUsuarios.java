/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class SistemaUsuarios {
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();
    
    public void agregarJugador(String n, String c, String nc, int s){
        jugadores.add(new Jugador(n, c, nc, s));
       
    }
    public void agregarUsuarioAdmin(String n, String c, String nc){
        administradores.add(new Administrador(n, c, nc));
       
    }
}
