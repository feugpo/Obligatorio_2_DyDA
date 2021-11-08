/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fernando
 */
public class Mazo {
    private ArrayList<Carta> cartas = new ArrayList();

    public Mazo() {
        Configuracion c = Sistema.getInstancia().getConfiguracion();
        for(Palo p : c.getPalos()){
            for(Valor v : c.getValores()){
                Carta carta = new Carta(p, v);
                cartas.add(carta);
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    void barajar() {
        Collections.shuffle(cartas);
    }
    
    public void eliminar(Carta c){
        cartas.remove(c);
    }
    
    public Carta tomarUna(){
        return cartas.get(0);
    }
    
    
    
    
}
