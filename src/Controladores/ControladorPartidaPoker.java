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
            if (juego != null) {
                mostrarMensajeListaEspera();
                mostrarJugadores();
            }
        }
        if (evento.equals(Juego.Eventos.rondaNueva)) {
            cargarDatosIniciales();
            mostrarPozo();
            mostrarMensajeMano();
            vista.habilitarBotones();
        }
        if (evento.equals(Juego.Eventos.apuestaNueva)) {
            if (juego.tiene(participante)) {
                Participante apostador = juego.apostador();
                String nombre = apostador.nombreUsu();
                vista.alertarApuesta(nombre, juego.getRondaActual().getApuesta());
            }
        }
        if (evento.equals(Juego.Eventos.retiroJugador)) {
            vista.mostrarCartas(traerNombresCartas());
        }
        if (evento.equals(Juego.Eventos.ganadorRonda)) {
            if (juego.getRondaActual().seEncuentra(participante)) {
                informarDeGanador();
            }
            vista.habilitarBotones();
        }
        if (evento.equals(Juego.Eventos.continuar)) {
            boolean puede = fachada.saldoSuficiente(participante.getJugador().getSaldo());
            if (juego.getParticipantes().size() > 1) {
                if (puede) {
                    if (juego.seEncuentra(participante)) {
                        vista.consultarSiContinua();
                    }
                } else {
                    juego.getRondaActual().retirarse(participante);
                    vista.avisarNoContinua();

                }
            }

        }
        if (evento.equals(Juego.Eventos.ganadorJuego)) {
            vista.avisarGanadorJuego(participante.nombreUsu());
        }

    }

    public void apostar(String apuesta) {
        int iRes = Integer.parseInt(apuesta);
        vista.inhabilitarBotones();
        juego.apostar(participante, iRes);

    }

    public void aceptarApuesta() {
        juego.aceptarApuesta(participante);
//        if (juego.getRondaActual().noHayPasadores()) {
//            juego.seleccionarGanadorRonda();
//        }
    }

    public void rechazarApuesta() {
        salirRonda();
//        if (juego.getRondaActual().noHayPasadores()) {
//            juego.seleccionarGanadorRonda();
//        }
    }

    private void cargarDatosIniciales() {
        vista.mostrarDatos(participante.getJugador().getNombreCompleto(), participante.getJugador().getSaldo());
        mostrarJugadores();
        vista.mostrarCartas(traerNombresCartas());
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

    public boolean listaEsperaLLena() {
        return fachada.listaEsperaLLena();
    }

    private void mostrarMensajeMano() {
        if (participante.getMano() != null) {
            String nomFigura = participante.getMano().getnombreFigura();
            String cartaAlta = participante.getMano().getNombreCartaAlta();
            vista.mensajeMano(nomFigura, cartaAlta);
        }
    }

    public void salirRonda() {
        vista.inhabilitarBotones();
        vista.vaciarMensaje();
        juego.retirarseRonda(participante);
    }

    public void salirJuego() {
        if (juego.getRondaActual() != null) {
            juego.quitar(this);
            juego.retirarseJuego(participante);
            vista.cerrarVista();
        } else {
            Sistema.getInstancia().salirListaEspera(participante);
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
//        if (juego.getRondaActual().getParticipantes().size() > 1) {
//            
//        }else{
//            vista.informarSobreGanadorRonda(ganador.nombreUsu(), "Los demas participantes se han retirado, Felicidades, eres el ganador!");
//        }

    }

    private void mostrarJugadores() {
        ArrayList<String> aux = new ArrayList();
        for (Participante p : juego.getParticipantes()) {
            aux.add(p.nombreUsu());
        }
        vista.mostrarJugadores(aux);
    }

    private void mostrarPozo() {
        if (juego.getRondaActual() != null) {
            vista.mostrarPozo(juego.getRondaActual().getPozo().getMonto());
        }
    }

}
