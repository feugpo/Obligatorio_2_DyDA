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
    private Carta laMasAlta;

    public Mano() {
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    
}
