/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Objects;

/**
 *
 * @author Fernando
 */
public class Carta implements Comparable<Carta> {
    private Palo palo;
    private Valor valor;

    public Carta(Palo palo, Valor valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String generarString() {
        return valor.getValor()+palo.getPalo();
    }

    public Palo getPalo() {
        return palo;
    }

    public Valor getValor() {
        return valor;
    }

    @Override
    public int compareTo(Carta c) {
        int ret = valor.compareTo(c.getValor());
        if(ret == 0){
            ret = palo.compareTo(c.getPalo());
        }
        return ret;
    }

    

    
    
    
    



    
    
    

    

    
    
    
}
