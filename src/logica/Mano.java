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
public class Mano implements Comparable<Mano> {

    private ArrayList<Carta> cartas = new ArrayList();
    private Figura figura;
    private ArrayList<Carta> figuraCartas;
    private Carta laMasAlta;

    public Mano() {
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void agregar(Carta c) {
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
    
    public void asignarLaMasAlta(){
        Carta max = null;
        if(figura != null){
            for(Carta c : cartas){
                if(max != null && !this.figuraCartas.contains(c) && c.compareTo(max) > 0 ){
                    max = c;
                }else if(max == null){
                    
                }
            }
        }else{
            for(Carta c : cartas){
                if(max!=null && c.compareTo(max)>0){
                    max = c;
                }else if (max == null){
                    max = c;
                }
            }
        }
        this.setLaMasAlta(max);
    }

    public void setFiguraCartas(ArrayList<Carta> figuraCartas) {
        this.figuraCartas = figuraCartas;
    }
    //Contingencia para retorno nulo?
    public Valor valorCartaFigura(){
        Carta c = this.getFiguraCartas().get(0);
        return c.getValor();
    }
    //Contingencia para retorno nulo?
    public Palo paloCartasColor(){
        Carta c = this.getFiguraCartas().get(0);
        return c.getPalo();
    }
    
    @Override
    public int compareTo(Mano m) {
        int ret = this.getFigura().compareTo(m.getFigura());
        return ret;
    }

    public ArrayList<String> generarNombreCartas() {
        ArrayList<String> nombres = new ArrayList(); 
        for(Carta c : cartas){
            nombres.add(c.generarString());
        }
        return nombres;
    }

    public String getnombreFigura() {
        if(figura != null){
            return figura.getNombre();                 
        }
        return null;
    }

    public String getNombreCartaAlta() {
        if(laMasAlta != null){
            return laMasAlta.generarString();
        }
        return null;
    }
}
