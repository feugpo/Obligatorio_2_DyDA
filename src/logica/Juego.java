/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Observer.Observable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public class Juego extends Observable {

    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> retirados = new ArrayList();
    private int continuan = 0;
    private int rondas;
    private Ronda rondaActual;
    private Date fecha;

    public enum Eventos {
        rondaNueva, apuestaNueva, hayGanador
    };

    public Ronda getRondaActual() {
        return rondaActual;
    }

    public Juego() {
    }

    public void agregar(Participante p) {
        participantes.add(p);
    }

    public void crearRonda() {
        Ronda ronda = new Ronda(participantes);
        rondas++;
        rondaActual = ronda;
        avisar(Eventos.rondaNueva);
    }
    
    public void crearRondaPasadores(){
        Ronda ronda = new Ronda(rondaActual.getPasadores(), rondaActual.getPozo());
        rondas++;
        rondaActual = ronda;
        avisar(Eventos.rondaNueva);
    }

    public void retirarse(Participante p) {
        participantes.remove(p);
        retirados.add(p);
    }

    public boolean lleno(int maximo) {
        return participantes.size() == maximo;
    }

    void datosIniciales() {
        fecha = new Date();
        for (Participante p : participantes) {
            p.iniciarSaldo();
        }

    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public Participante buscar(Jugador j) {
        for (Participante p : participantes) {
            if (p.comparar(j)) {
                return p;
            }
        }
        return null;
    }

    public void apostar(Participante p, int monto) {
        rondaActual.apostar(p, monto);
        avisar(Eventos.apuestaNueva);
    }
    
    
}
