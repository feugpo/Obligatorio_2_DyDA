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
public class Mano {
    private ArrayList<Carta> cartas = new ArrayList();
    private Figura figura;
    private ArrayList<Carta> figuraCartas;
    private Carta laMasAlta;

    public Mano() {
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public void agregar(Carta c){
        cartas.add(c);
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public Carta getLaMasAlta() {
        return laMasAlta;
    }

    public void setLaMasAlta(Carta laMasAlta) {
        this.laMasAlta = laMasAlta;
    }

    public ArrayList<Carta> getFiguraCartas() {
        return figuraCartas;
    }

    public void setFiguraCartas(ArrayList<Carta> figuraCartas) {
        this.figuraCartas = figuraCartas;
    }
    
    
    
    
    
}
