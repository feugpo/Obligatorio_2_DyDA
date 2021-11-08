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
public class SistemaJuegos {
    private ArrayList<Juego> juegos = new ArrayList();
    private ArrayList<Jugador> listaEspera = new ArrayList();
    private Configuracion configuracion = new Configuracion();

    public Configuracion getConfiguracion() {
        return configuracion;
    }
    
    
    
    
    public void crearConfiguracion(int luz, int participantes, ArrayList<Figura> figuras, ArrayList<Valor> valores, ArrayList<Palo> palos){
        this.configuracion = new Configuracion(luz,participantes,figuras,valores,palos);
        //this.configuracion.setLuz(luz);
        //this.configuracion.setparticipantes(participantes);
    }
    
    
    //llamar desde sistema usuario a traves de la fachada
    public void agregar(Jugador j){
        listaEspera.add(j);
        if(listaEspera.size()==configuracion.getParticipantes()){
            crearJuego();
        }
    }
    
    
    
    //ES BUENA PRACTICA USAR DOS METODOS SEPARADOS DENTRO DE LA CLASE EN VEZ DE UNO GRANDE
    public void crearJuego(){
        Juego juego = new Juego();
        for(Jugador j : listaEspera){
            Participante p = new Participante(j);    //ES LA MANERA CORRECTA DE HACERLO??
            juego.agregar(p);
        }
        juegos.add(juego);
    }
    
    
    
}
