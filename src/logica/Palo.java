/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fernando
 */
public class Palo implements Comparable<Palo> {
    private String palo;
    private int puntaje;

    public Palo(String palo, int puntaje) {
        this.palo = palo;
        this.puntaje = puntaje;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public int compareTo(Palo p) {
        int ret = Integer.compare(this.puntaje, p.puntaje);
        return ret;
    }

    
    
    
    
    
}
