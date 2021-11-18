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
    }

    public Juego agregar(Jugador j) throws PokerException{
        if(juegoEspera.buscar(j)!=null)throw new PokerException("Ya estas en la lista de espera");
        if(!j.saldoSuficiente(configuracion.getLuz(), configuracion.getParticipantes()))throw new PokerException("No tienes el saldo suficiente para participar");
        Participante p = new Participante(j);
        juegoEspera.agregar(p); 
        return juegoEspera;
    }

    public boolean listaEsperaLLena() {
        int numero = configuracion.getParticipantes();
        if (juegoEspera.lleno(numero)) {
            empezarJuego();
            return true;
        }       
        return false;
    }

    public void empezarJuego() {
        Juego porComenzar = juegoEspera;
        porComenzar.datosIniciales();
        juegos.add(porComenzar);
        nuevoJuegoEspera();
        porComenzar.crearRonda();
        Sistema.getInstancia().avisar(Sistema.Eventos.juegoNuevo);
    }
    
    public int participantesFaltantes(){
        return configuracion.getParticipantes() - juegoEspera.getParticipantes().size();
    }
    
    public boolean saldoSuficiente(int saldo) {
        return saldo > configuracion.getLuz();
    }
    
    public void salirListaEspera(Participante p){
        juegoEspera.getParticipantes().remove(p);
        Sistema.getInstancia().avisar(Sistema.Eventos.modificoListaEspera);
    } 
    
    public ArrayList<Juego> juegosEnProgreso(){
        ArrayList<Juego> ret = new ArrayList();
        for(Juego j : juegos){
            if(j.getGanador() == null){
                ret.add(j);
            }
        }
        return ret;
    }
}
