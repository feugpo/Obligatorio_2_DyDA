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
public class SistemaJuegos {

    private ArrayList<Juego> juegos = new ArrayList();
    private Juego juegoEspera = new Juego();
    private Configuracion configuracion = new Configuracion();

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void nuevoJuegoEspera() {
        juegoEspera = new Juego();
    }

    public void crearConfiguracion(int luz, int participantes, ArrayList<Figura> figuras, ArrayList<Valor> valores, ArrayList<Palo> palos) {
        this.configuracion = new Configuracion(luz, participantes, figuras, valores, palos);
        //this.configuracion.setLuz(luz);
        //this.configuracion.setparticipantes(participantes);
    }

    //llamar desde sistema usuario a traves de la fachada
    public Juego agregar(Jugador j) {
        Participante p = new Participante(j);
        juegoEspera.agregar(p);
        //agregar un evento para se agrego una persona a lista espera
        return juegoEspera;
    }

    public void listaEsperaLLena() {
        int numero = configuracion.getParticipantes(); 
        if (juegoEspera.lleno(numero)) {
            Sistema.getInstancia().avisar(Sistema.Eventos.juegoNuevo);
        }
    }

    public void empezarJuego() {
        Juego porComenzar = juegoEspera;
        porComenzar.datosIniciales();
        juegos.add(porComenzar);
        nuevoJuegoEspera();
        porComenzar.crearRonda();
    }
}
