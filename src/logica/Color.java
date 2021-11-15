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
public class Color extends Figura {

    public Color(String nombre, int puntaje) {
        super(nombre, puntaje);
    }

    @Override
    public void evaluar(Mano mano) {
        ArrayList<Carta> m = mano.getCartas();
        Carta primera = m.get(0);
        boolean mismo = true;
        int i = 1;
        while (i < 5 && mismo) {
            if (primera.getPalo() != m.get(i).getPalo()) {
                mismo = false;
            }
            i++;
        }
        if (mismo) {
            if (mano.getFigura() != null && this.compareTo(mano.getFigura()) > 0) {
                mano.setFigura(this);
            } else if (mano.getFigura() == null) {
                mano.setFigura(this);
            }
        }
    }
    

}
