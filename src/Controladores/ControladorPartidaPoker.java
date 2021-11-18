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
        this.vista.inhabilitarBotones();
        fachada.agregar(this);
        juego.agregar(this);
        cargarDatosIniciales();
        mostrarMensajeListaEspera();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Sistema.Eventos.modificoListaEspera)) {
            mostrarMensajeListaEspera();
            mostrarMensajeMano();
        }
        if (evento.equals(Sistema.Eventos.juegoNuevo)) {
            fachada.empezarJuego();
            vista.mostrarCartas(traerNombresCartas());
        }
        if (evento.equals(Juego.Eventos.rondaNueva)) {
            cargarDatosIniciales();
            mostrarPozo();
            mostrarMensajeMano();
            vista.habilitarBotones();
        }
        if (evento.equals(Juego.Eventos.apuestaNueva)) {
            if (juego.getRondaActual().getPasadores().contains(participante)) {    //LOGICA HAY Q SACARLA
                String apostador = juego.getRondaActual().getParticipantes().get(0).getJugador().getNombreUsuario(); //CAMBIAR POR UN METODO
                vista.alertarApuesta(apostador, juego.getRondaActual().getApuesta());
            }
        }
        if (evento.equals(Juego.Eventos.retiroJugador)) {
            mostrarJugadores();
        }
        if (evento.equals(Juego.Eventos.ganadorRonda)) {
            if (juego.getRondaActual().seEncuentra(participante)) {
                informarDeGanador();
            }
        }
        if (evento.equals(Juego.Eventos.continuar)) {
            boolean puede = fachada.saldoSuficiente(participante.getJugador().getSaldo());
            if (puede) {
                if (juego.seEncuentra(participante)) {
                    vista.consultarSiContinua();
                }
            } else {
                juego.getRondaActual().retirarse(participante);
                vista.avisarNoContinua();

            }
        }
        if (evento.equals(Juego.Eventos.ganadorJuego)) {
            vista.avisarGanadorJuego(participante.nombreUsu());
        }
        if (evento.equals(Sistema.Eventos.modificoListaEspera)) {
            if( juego!= null ){
                mostrarJugadores();
                mostrarMensajeListaEspera();
            }
        }

    }

    public boolean listaEsperaLLena() {
        return fachada.listaEsperaLLena();
    }

    public void apostar(int apuesta) {
        vista.inhabilitarBotones();
        juego.apostar(participante, apuesta); //CAMBIAR EL EVENTO EN JUEGO VA A LLAMAR A RONDA 

    }

    public void aceptarApuesta() {

        if (juego.getRondaActual().aceptarApuesta(participante)) {
            juego.seleccionarGanadorRonda();
        }
    }

    public void rechazarApuesta() {
        salirRonda();
    }

    private void cargarDatosIniciales() {
        vista.mostrarDatos(participante.getJugador().getNombreCompleto(), participante.getJugador().getSaldo());
        mostrarJugadores();
        vista.mostrarCartas(traerNombresCartas());
        vista.habilitarBotones();
    }

    public ArrayList<String> traerNombresCartas() {
        if (participante.getMano() != null) {
            return participante.getMano().generarNombreCartas();
        }
        return null;
    }

    private void mostrarMensajeListaEspera() {
        if (!listaEsperaLLena()) {
            int faltantes = fachada.participantesFaltantes();
            vista.mensajeListaEspera(faltantes);
        }
    }

    //CAMBIAR POR UN TRYU CATCH?? ELIMINAR LOGICA
    private void mostrarMensajeMano() {
        if (participante.getMano() != null) {
            String nomFigura = participante.getMano().getnombreFigura();
            String cartaAlta = participante.getMano().getNombreCartaAlta();
            //participante.getMano().generarReporteMano();
            vista.mensajeMano(nomFigura, cartaAlta);
        }

    }

    public void salirRonda() {
        juego.retirarseRonda(participante);
        vista.inhabilitarBotones();
        vista.vaciarMensaje();
    }

    public void salirJuego() {
        if(juego.getRondaActual()!=null){
            juego.quitar(this);
            juego.retirarseJuego(participante);
            vista.cerrarVista();
        }else{
            //Sistema.getInstancia().salirListaEspera(participante);
        }
        
    }

    public void pasar() {
        vista.inhabilitarBotones();
        juego.pasar(participante);
    }

    public void continuar() {
        juego.continuar(juego.getRondaActual().getGanador());
    }

    private void informarDeGanador() {
        Participante ganador = juego.getRondaActual().getGanador();
        if (ganador.getMano().getFigura() != null) {
            vista.informarSobreGanadorRonda(ganador.nombreUsu(), ganador.getMano().getFigura().getNombre());
        } else {
            vista.informarSobreGanadorRonda(ganador.nombreUsu(), ganador.getMano().getLaMasAlta().generarString());
        }

    }

    private void mostrarJugadores() {
        vista.mostrarJugadores(juego.getParticipantes());
    }

    private void mostrarPozo() {
        if (juego.getRondaActual() != null) {
            vista.mostrarPozo(juego.getRondaActual().getPozo().getMonto());
        }
    }

}
