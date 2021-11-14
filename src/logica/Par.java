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
public class Par extends Figura {

    public Par(String nombre, int puntaje) {
        super(nombre, puntaje);
    }

    @Override
    public void evaluar(Mano mano) {
        ArrayList<Carta> m = mano.getCartas();
        for (int x = 0; x < 4; x++) {
            ArrayList<Carta> aux = new ArrayList();
            aux.add(m.get(x));
            int y = 1;
            while (y < 5) {
                if (m.get(x) == m.get(y)) {
                    aux.add(m.get(y));
                }
                y++;
            }
            if (aux.size() == 2) {
                Carta max = null;
                //if(aux.get(0)>aux.get(1))max = aux.get(0);

                if (mano.getFigura() != null) {

                } else {
                    mano.setFigura(this);

                }
            }
        }

    }

}
