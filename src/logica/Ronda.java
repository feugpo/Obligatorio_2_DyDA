/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Observer.Observable;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class Ronda extends Observable {

    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> pasadores = new ArrayList();
    private int apuesta;
    //private Participante ganador;
    private Mazo mazo;
    private Pozo pozo;
    
    //LLEVAR EVENTOS AL JUEGO 
    public enum Eventos {
        apuestaNueva, hayGanador
    };

    public Ronda(ArrayList<Participante> p) {
        this.mazo = new Mazo();
        this.pozo = new Pozo();
        participantes = p;
        //para mi ronda nueva preciso cobrar la luz, barajar, repartir, y ya saber que mano tengo para mostrar los datos
        cobrarLuz();
        repartir(); //esto es correcto?
        evaluarManos();
    }

    public ArrayList<Participante> getPasadores() {
        return pasadores;
    }
    
    

    public Ronda(ArrayList<Participante> pptes, Pozo pozo) {
        this.mazo = new Mazo();
        this.pozo = pozo;
        this.participantes = pptes;
    }

    public void agregar(Participante p) {
        participantes.add(p);
    }

    public void repartir() {
        mazo.barajar();
        for (Participante p : participantes) {
            p.nuevaMano();
            int i = 0;
            while (i < 5) {
                Carta c = mazo.tomarUna(); //metodo en mazo tomar una
                p.getMano().agregar(c);  //metodo en mano agregar carta 
                mazo.eliminar(c); //metodo en mazo eliminar carta
                i++;
            }
        }
    }

    //Luego de repartir asigna la figura si tiene y la carta mas alta si corresponde 
    public void evaluarManos() {
        for (Participante p : participantes) {
            ArrayList<Figura> listaFiguras = Sistema.getInstancia().getConfiguracion().getFiguras();
            for (Figura f : listaFiguras) {
                f.evaluar(p.getMano());
            }
        }
    }

    public void cobrarLuz() {
        int luz = Sistema.getInstancia().getConfiguracion().getLuz();
        for (Participante p : participantes) {
            cobrarMontoLuzApuesta(p, luz);
        }
    }

    public void pasar(Participante p) {
        participantes.remove(p);
        pasadores.add(p);
    }

    //ESTA ES PARA CUANDO LA PERSONA SE VA CERRANDO EL JUEGO // O SE VA DE LA RONDA POR AHORA
    public void retirarse(Participante p) {
        participantes.remove(p);
        pasadores.remove(p);
    }

    //PENSAR COMO UNO LARGA EVENTO Y EL OTRO NO (LUZ VS APUESTA)
    //metodo apostar con el evento del observer 
    public void apostar(Participante p, int monto) {
        cobrarMontoLuzApuesta(p, monto);
        this.apuesta = monto;
        //pasamos todos menos el apostador a la lista de pasadores
        ArrayList<Participante> aux = new ArrayList();
        for (Participante parti : participantes) {
            
            if (parti != p) {
                aux.add(parti);
            }
        }
        for (Participante parti1 : aux){
            pasar(parti1);
        }
        avisar(Eventos.apuestaNueva);
    }
    
    //AGREGAR LOGICA SI PASADORES == VACIO AL FINAL => SELECCIONAR UN GANADOR????
    public void aceptarApuesta(Participante p){
        cobrarMontoLuzApuesta(p, apuesta);
        pasadores.remove(p);
        participantes.add(p);
    }
    

    public void cobrarMontoLuzApuesta(Participante p, int monto) {
        p.getJugador().pagar(monto);
        p.sumarApostado(monto);
        pozo.agregar(monto);
    }

    
}
