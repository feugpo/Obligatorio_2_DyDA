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
public abstract class Figura {
    private String nombre;
    private int puntaje;

    public Figura(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    public abstract void evaluar(Mano mano);
    
    public int compareTo(Figura f){
        int ret = Integer.compare(f.puntaje, this.puntaje);
        return ret;
    }
}
