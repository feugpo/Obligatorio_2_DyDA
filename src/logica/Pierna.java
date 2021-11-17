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
public class Pierna extends Figura {

    public Pierna(String nombre, int puntaje) {
        super(nombre, puntaje);
    }

    @Override
    public void evaluar(Mano mano) {
        ArrayList<Carta> m = mano.getCartas();
        //Compara buscando iguales
        for (int x = 0; x < 3; x++) {
            ArrayList<Carta> aux = new ArrayList();
            aux.add(m.get(x));
            int y = x+1;
            while (y < 5) {
                if (m.get(x).getValor() == m.get(y).getValor()) {
                    aux.add(m.get(y));
                }
                y++;
            }
            //Si las iguales son una pierna
            if (aux.size() == 3) {
                //Si hay una figura existente y la pierna es mayor (ej. par)
                if (mano.getFigura() != null && this.compareTo(mano.getFigura()) > 0) {
                    mano.setFigura(this);
                    mano.setFiguraCartas(aux);
                } else if(mano.getFigura() == null){
                    //si no hay figura => uso la q encontre
                    mano.setFigura(this);
                    mano.setFiguraCartas(aux);
                }
                //si hay una figura y es mayor => no asigna nada
            }
        }
    }

    @Override
    public Participante desempatar(Participante p1, Participante p2) {
        if(p1.getMano().valorCartaFigura().compareTo(p2.getMano().valorCartaFigura()) > 0){
            return p1;
        }
        return p2;
    }

}
