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
    private Sistema fachada = Sistema.getInstancia();

    public ControladorPartidaPoker(VistaPartidaPoker vista, Juego juego, Participante participante) {
        this.vista = vista;
        this.participante = participante;
        this.juego = juego;
        fachada.agregar(this);
        juego.agregar(this);
        cargarDatosIniciales();
        this.vista.inhabilitarBotones();
        mostrarMensajeListaEspera();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sistema.Eventos.modificoListaEspera)){
            mostrarMensajeListaEspera();
        }
        if (evento.equals(Sistema.Eventos.juegoNuevo)) {
            fachada.empezarJuego();
            vista.mostrarCartas(traerNombresCartas());
        }
        if (evento.equals(Juego.Eventos.rondaNueva)) {
            cargarDatosIniciales();
            mostrarMensajeMano();
            vista.habilitarBotones();
        }
        if (evento.equals(Juego.Eventos.apuestaNueva)) {
            if (juego.getRondaActual().getPasadores().contains(participante)) {
                vista.cargarVistaParticipante(participante);
                vista.alertarApuesta();
            }
        }
    }    

    public boolean listaEsperaLLena() {
        return fachada.listaEsperaLLena();
    }
    
    public void apostar(int apuesta) {
        juego.apostar(participante, apuesta); //CAMBIAR EL EVENTO EN JUEGO VA A LLAMAR A RONDA 
        vista.inhabilitarBotones();
    }

    public void aceptarApuesta() {
        juego.getRondaActual().aceptarApuesta(participante);
    }

    public void rechazarApuesta() {
        salir();
    }

    private void cargarDatosIniciales() {
        vista.mostrarTitulo(participante.getJugador().getNombreCompleto());
        vista.mostrarCartas(traerNombresCartas());
    }

    public ArrayList<String> traerNombresCartas() {
        if(participante.getMano()!= null){
            return participante.getMano().generarNombreCartas();
        }
        return null;
    }

    private void mostrarMensajeListaEspera() {
        if(!listaEsperaLLena()){
            int faltantes = fachada.participantesFaltantes();
            vista.mensajeListaEspera(faltantes);
        }
    }

    private void mostrarMensajeMano() {
        String nomFigura = participante.getMano().getnombreFigura();  
        String cartaAlta = participante.getMano().getNombreCartaAlta();
        //participante.getMano().generarReporteMano();
        vista.mensajeMano(nomFigura, cartaAlta);
        
        
    }

    public void salir() {
        if(juego.getRondaActual()!=null){
            juego.getRondaActual().retirarse(participante);
            vista.mostrarCartas(traerNombresCartas());
            vista.inhabilitarBotones();
            vista.vaciarMensaje();
        }else{
            juego.retirarse(participante);
        }
    }

    public void pasar() {
        boolean pasaronTodos = juego.getRondaActual().pasar(participante);
        if(pasaronTodos){
            juego.crearRondaPasadores();
        }
    }

}
