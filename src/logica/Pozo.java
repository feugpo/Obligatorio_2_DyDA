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
public class Pozo {
    private int monto;

    public Pozo() {
    }

    public int getMonto() {
        return monto;
    }
    
    
    
    void agregar(int apuesta) {
        monto += apuesta;
    }

    void premiar(Participante ganador) {
        ganador.sumarGanado(monto);
        ganador.cobrar(monto); 
    }

}

