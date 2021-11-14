/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Observer.Observable;
import Observer.Observador;
import Vistas.VistaPartidaPoker;
import java.util.ArrayList;
import logica.Juego;
import logica.Participante;
import logica.Sistema;
/**
 *
 * @author Gabriel
 */
public class ControladorPartidaPoker implements Observador {
    
    
    private VistaPartidaPoker vista;
    private Participante participante;
    private Juego juego;
    private Sistema fachada= Sistema.getInstancia();

    public ControladorPartidaPoker(VistaPartidaPoker vista, Juego juego ,Participante participante) {
        this.vista = vista;
        this.participante = participante;
        this.juego=juego;
        fachada.agregar(this);
        juego.agregar(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
       if(evento.equals(Sistema.Eventos.juegoNuevo)){
           vista.cargarVistaParticipante(participante);
       }
    }
    
   public ArrayList<String> rutaCartas(){
       return participante.generarUrlCarta();
    }  
}
