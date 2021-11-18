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
public class Ronda {

    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> pasadores = new ArrayList();
    private int apuesta;
    private Participante ganador;
    private Mazo mazo;
    private Pozo pozo;

    public Ronda(ArrayList<Participante> p) {
        this.mazo = new Mazo();
        this.pozo = new Pozo();
        for (Participante par : p) {
            participantes.add(par);
        }
        //para mi ronda nueva preciso cobrar la luz, barajar, repartir, y ya saber que mano tengo para mostrar los datos
        cobrarLuz();
        repartir(); //esto es correcto?
        evaluarManos();
    }

    public int getApuesta() {
        return apuesta;
    }
    
    

    public Participante getGanador() {
        return ganador;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public ArrayList<Participante> getPasadores() {
        return pasadores;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public Ronda(ArrayList<Participante> pptes, Pozo pozo) {
        this.mazo = new Mazo();
        this.pozo = pozo;
        for (Participante par : pptes) {
            participantes.add(par);
        }
        cobrarLuz();
        repartir(); //esto es correcto?
        evaluarManos();
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
            p.getMano().asignarLaMasAlta();
        }
    }

    public void cobrarLuz() {
        int luz = Sistema.getInstancia().getConfiguracion().getLuz();
        for (Participante p : participantes) {
            cobrarMontoLuzApuesta(p, luz);
        }
    }

    public boolean pasar(Participante p) {
        participantes.remove(p);
        pasadores.add(p);
        return pasaronTodos();
    }

    private boolean pasaronTodos() {
        return participantes.isEmpty();
    }

    public boolean retirarse(Participante p) {
        participantes.remove(p);
        pasadores.remove(p);
        p.vaciarMano();
        return hayGanadorRondaPorDefecto();
    }

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
        //usando una lista auxiliar
        for (Participante parti1 : aux) {
            pasar(parti1);
        }
    }

    //AGREGAR LOGICA SI PASADORES == VACIO AL FINAL => SELECCIONAR UN GANADOR????
    public boolean aceptarApuesta(Participante p) {
        cobrarMontoLuzApuesta(p, apuesta);
        pasadores.remove(p);
        participantes.add(p);
        return pasadores.isEmpty();
    }

    public void cobrarMontoLuzApuesta(Participante p, int monto) {
        p.getJugador().pagar(monto);
        p.sumarApostado(monto);
        pozo.agregar(monto);
    }

    public boolean seEncuentra(Participante participante) {
        return participantes.contains(participante) || pasadores.contains(participante);
    }

    public boolean hayGanadorRondaPorDefecto() {
        boolean ret = participantes.size() + pasadores.size() == 1;
        if (ret) {
            if (participantes.isEmpty()) {
                ganador = pasadores.get(0);
            } else {
                ganador = participantes.get(0);
            }
            pozo.premiar(ganador);
        }
        return ret;
    }

    public void seleccionarGanadorRonda() {
        ganador = participantes.get(0);
        for (int x = 1; x < participantes.size(); x++) {
            if (participantes.get(x).getMano().compareTo(ganador.getMano()) > 0) {
                ganador = participantes.get(x);
            } else if (participantes.get(x).getMano().compareTo(ganador.getMano()) == 0) {
                ganador = ganador.getMano().getFigura().desempatar(ganador, participantes.get(x));
            }
        }
        pozo.premiar(ganador);
    }

}
