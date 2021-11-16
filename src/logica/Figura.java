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
public abstract class Figura implements Comparable<Figura>{
    private String nombre;
    private int puntaje;

    public Figura(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    
    
    public abstract void evaluar(Mano mano);

    @Override
    public int compareTo(Figura f) {
        int ret = Integer.compare(f.puntaje, this.puntaje);
        //DESEMPAAR 
        return ret;
    }
    
    
    
}
