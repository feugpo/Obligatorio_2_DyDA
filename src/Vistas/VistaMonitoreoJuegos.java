/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.ArrayList;
import logica.Juego;
import logica.Participante;

/**
 *
 * @author Fernando
 */
public interface VistaMonitoreoJuegos {
    
    public void mostrarJuegos(ArrayList<Juego> juegosEnProgreso);
    
    public void mostrarJugadores(ArrayList<Participante> participantes);
    
}
