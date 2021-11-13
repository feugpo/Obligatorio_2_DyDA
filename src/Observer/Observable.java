/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Observable {

    private ArrayList<Observador> observadores = new ArrayList();

    public void agregar(Observador o) {
        if (!observadores.contains(o)) {
            observadores.add(o);
        }

    }

    public void quitar(Observador o) {
        observadores.remove(o);
    }

    public void avisar(Object evento) {
        ArrayList<Observador> observadorCopia = new ArrayList(observadores);
        for (Observador o : observadorCopia) {
            try {
                o.actualizar(evento, this);

            } catch (Exception e) {
                System.out.println("Error  " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
