/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public class Juego {
    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> retirados = new ArrayList();
    private int rondas;
    private Ronda rondaActual;
    private Date fecha = new Date();

    public Juego() {
    }
    
    public void agregar(Participante p){
        this.participantes.add(p);
    }
    
    public void crearRonda(){
        Ronda ronda = new Ronda();
        for(Participante p : participantes){
            ronda.agregar(p);
        }
        rondas++;
        rondaActual = ronda;
    }
    
    
    
}
