/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Observer.Observable;
import Observer.Observador;
import Vistas.VistaPartidaPoker;
import iu.MonitoreoJuegos;
import java.util.ArrayList;
import logica.Administrador;
import logica.Juego;
import logica.Sistema;

/**
 *
 * @author Fernando
 */
public class ControladorMonitoreoJuegos implements Observador{
    
    private MonitoreoJuegos vista;
    private Administrador administrador;
    private Sistema fachada = Sistema.getInstancia();

    public ControladorMonitoreoJuegos(MonitoreoJuegos vista, Administrador administrador) {
        this.vista = vista;
        this.administrador = administrador;
        fachada.agregar(this);
        mostrarJuegos();
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sistema.Eventos.juegoNuevo)){
            mostrarJuegos();
        }
        if(evento.equals(Juego.Eventos.ganadorRonda) || evento.equals(Juego.Eventos.rondaNueva)){
            mostrarJuegos();
            seleccionJuego((Juego)origen);
        }
        if(evento.equals(Juego.Eventos.ganadorJuego)){
            origen.quitar(this);
            mostrarJuegos();
            
        }
    }
    
    private void mostrarJuegos() {
        ArrayList<Juego> juegos = fachada.juegosEnProgreso();
        for(Juego j : juegos){
            j.agregar(this);
        }
        vista.mostrarJuegos(juegos);
    }

    public void seleccionJuego(Juego juego) {
        if(juego!=null){
            vista.mostrarJugadores(juego.participantesHistoria());
        }
    }
    
    
    

    
    
}
