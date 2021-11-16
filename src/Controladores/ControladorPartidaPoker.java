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
import logica.Ronda;
import logica.Sistema;

/**
 *
 * @author Gabriel
 */
public class ControladorPartidaPoker implements Observador {

    private VistaPartidaPoker vista;
    private Participante participante;
    private Juego juego;
    private Sistema fachada = Sistema.getInstancia();

    public ControladorPartidaPoker(VistaPartidaPoker vista, Juego juego, Participante participante) {
        this.vista = vista;
        this.participante = participante;
        this.juego = juego;
        fachada.agregar(this);
        juego.agregar(this);
        //LLEVAR ESTOS 2 ULTIMOS PARA EL CONTROLADOR
        vista.cargarVistaParticipante(participante);
        listaEsperaLLena();
        //
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Sistema.Eventos.juegoNuevo)) {
            fachada.empezarJuego();
        }
        if (evento.equals(Juego.Eventos.rondaNueva)) {
            vista.cargarVistaParticipante(participante);
            juego.getRondaActual().agregar(this);//Esto se debe hacer acá? //Agregar observador a la lista del observado
        }
        if (evento.equals(Ronda.Eventos.apuestaNueva)) {
            if (juego.getRondaActual().getPasadores().contains(participante)) {
                vista.cargarVistaParticipante(participante);
                vista.alertarApuesta();
            }
            

        }
    }

    public ArrayList<String> rutaCartas() {
        return participante.generarUrlCarta();
    }

    public void apostar(int apuesta) {
        //juego.apostar(participante, apuesta); CAMBIAR EL EVENTO EN JUEGO VA A LLAMAR A RONDA 
        juego.getRondaActual().apostar(participante, apuesta);
    }

    public void listaEsperaLLena() {
        fachada.listaEsperaLLena();
    }

    public void aceptarApuesta() {
        juego.getRondaActual().aceptarApuesta(participante);
    }

    public void rechazarApuesta() {
        juego.getRondaActual().retirarse(participante);
        vista.cargarVistaParticipante(participante);
    }
}
