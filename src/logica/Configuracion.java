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
public class Configuracion {
    private int luz;
    private int participantes;
    private ArrayList<Figura> figuras;
    private ArrayList<Valor> valores;
    private ArrayList<Palo> palos;

    public Configuracion() {
    }

    public Configuracion(int luz, int participantes, ArrayList<Figura> figuras, ArrayList<Valor> valores, ArrayList<Palo> palos) {
        this.luz = luz;
        this.participantes = participantes;
        this.figuras = figuras;
        this.valores = valores;
        this.palos = palos;
    }
    
    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public int getParticipantes() {
        return participantes;
    }

    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figura> figuras) {
        this.figuras = figuras;
    }

    public ArrayList<Valor> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Valor> valores) {
        this.valores = valores;
    }

    public ArrayList<Palo> getPalos() {
        return palos;
    }

    public void setPalos(ArrayList<Palo> palos) {
        this.palos = palos;
    }
    
    
    
    
}
