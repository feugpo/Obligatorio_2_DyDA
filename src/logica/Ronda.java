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
public class Ronda {
    private ArrayList<Participante> participantes = new ArrayList();
    private ArrayList<Participante> pasadores = new ArrayList();
    private int apuesta;
    //private Participante ganador;
    private Mazo mazo;
    private Pozo pozo;
    
    public Ronda() {
        this.mazo = new Mazo();
        this.pozo = new Pozo();
    }

    public Ronda(ArrayList<Participante> pptes, Pozo pozo) {
        this.mazo = new Mazo();
        this.pozo = pozo;
        this.participantes = pptes;
    }
    
    public void agregar(Participante p){
        participantes.add(p);
    }
    
    public void repartir(){
        mazo.barajar();
        for(Participante p : participantes){
            int i = 0;
            while(i<5){
                Carta c = mazo.tomarUna(); //metodo en mazo tomar una
                p.getMano().agregar(c);  //metodo en mano agregar carta 
                mazo.eliminar(c); //metodo en mazo eliminar carta
                i++;
            }
        }
    }
    
    public void cobrarLuz(){
        int luz = Sistema.getInstancia().getConfiguracion().getLuz();
        for(Participante p : participantes){
            apostar(p, luz);
        }
    }
    
    public void pasar(Participante p){
        participantes.remove(p);
        pasadores.add(p);
    }
    //ESTA ES PARA CUANDO LA PERSONA SE VA CERRANDO EL JUEGO
    public void retirarse(Participante p){
        participantes.remove(p);
        pasadores.remove(p);
    }
    
    //PENSAR COMO UNO LARGA EVENTO Y EL OTRO NO (LUZ VS APUESTA)
    //metodo apostar con el evento del observer 
    public void apostar(Participante p, int monto){
        p.getJugador().pagar(monto);
        p.sumarApostado(monto);
        pozo.agregar(monto);
    }
    
    // NO SE SI LO VAMOS A HACER ASÍ
    public void estadoRonda(){
        if(participantes.isEmpty()){
            //COMO LLEGO AL JUEGO PARA CREAR UNA NUEVA RONDA CON EL MISMO POZO
            Ronda nueva = new Ronda(participantes, pozo);
            //Crear la vista para la nueva ronda
        }else{
            //QUIENES DE LOS Q APOSTARON TIENEN LA FIGURA MAS ALTA
        }
    }
}