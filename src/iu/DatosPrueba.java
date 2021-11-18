/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.util.ArrayList;
import logica.Color;
import logica.Figura;
import logica.Palo;
import logica.Par;
import logica.Pierna;
import logica.Sistema;
import logica.Valor;

/**
 *
 * @author Fernando
 */
public class DatosPrueba {
    public static void cargar(){
        Sistema sistema = Sistema.getInstancia();
        
        //JUGADORES
        sistema.agregarJugador("Maria", "123", "Maria Gomez", 120);
        sistema.agregarJugador("Juan", "123", "Juan Cruz", 80);
        sistema.agregarJugador("Nicolas", "123", "Nicolas Barreiro", 80);
        sistema.agregarJugador("Ana", "123", "Ana Maria",60);
        sistema.agregarJugador("Pedro", "123", "Pedro FlintStone", 120);
        //ADMINISTRADORES
        sistema.agregarUsuarioAdmin("Gabriel", "123", "Gabriel Abelenda");
        sistema.agregarUsuarioAdmin("Fernando", "123", "Fernando Ugarte");
        //CONFIGURACION
        //luz
        int luz = 5;
        //numero participantes por juego
        int participantes = 3;
        //figuras posibles
        ArrayList<Figura> figuras = new ArrayList();
        Par par = new Par("par", 1);
        Pierna pierna = new Pierna("pierna", 2);
        Color color = new Color("color", 3);
        figuras.add(par);
        figuras.add(pierna);
        figuras.add(color);
        //valores de cartas
        ArrayList<Valor> valores = new ArrayList();
        valores.add(new Valor("1", 1));
        valores.add(new Valor("2", 2));
        valores.add(new Valor("3", 3));
        valores.add(new Valor("4", 4));
        valores.add(new Valor("5", 5));
        valores.add(new Valor("6", 6));
        valores.add(new Valor("7", 7));
        valores.add(new Valor("8", 8));
        valores.add(new Valor("9", 9));
        valores.add(new Valor("10", 10));
        valores.add(new Valor("J", 11));
        valores.add(new Valor("Q", 12));
        valores.add(new Valor("K", 13));
        valores.add(new Valor("A", 14));
        //palos de cartas
        ArrayList<Palo> palos = new ArrayList();
        palos.add(new Palo("p",1));
        palos.add(new Palo("t",2));
        palos.add(new Palo("d",3));
        palos.add(new Palo("c",4));
        sistema.crearConfiguracion(luz, participantes, figuras, valores, palos);
        //COMO AVISAR SI LA LUZ O PARTICIPANTES NO SON VÁLIDOS?
        
        
    }
}
