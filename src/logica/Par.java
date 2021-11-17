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
        //Compara buscando iguales
        for (int x = 0; x < 4; x++) {
            ArrayList<Carta> aux = new ArrayList();
            Carta c1 = m.get(x);
            aux.add(c1);
            int y = x+1;
            while (y < 5) {
                Carta c2 = m.get(y);
                if (c1.getValor().compareTo(c2.getValor()) == 0) {
                    aux.add(c2);
                }
                y++;
            }
            //Si las iguales son un par
            if (aux.size() == 2) {
                //Si hay una figura existente Y es un par
                if (mano.getFigura() != null && this.compareTo(mano.getFigura()) == 0) {
                    int comp = aux.get(0).compareTo(mano.getFiguraCartas().get(0));   // EMPROLIJAR TODO ESTO 
                    //Si la carta del par encontrado es mayor a la del guardado => lo sustituyo
                    if (comp > 0) {
                        mano.setFigura(this);
                        mano.setFiguraCartas(aux);
                    }
                } else if (mano.getFigura() == null) {
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
        int res = p1.getMano().valorCartaFigura().compareTo(p2.getMano().valorCartaFigura());
        if (res > 0) {
            return p1;
        } else if (res == 0) {
            if (p1.getMano().getLaMasAlta().compareTo(p2.getMano().getLaMasAlta()) > 0) {
                return p1;
            }
        }
        return p2;
    }
}
