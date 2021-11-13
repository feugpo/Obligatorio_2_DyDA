/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Observer.Observable;
import Observer.Observador;
import Vistas.VistaPartidaPoker;
import logica.Participante;
import logica.Sistema;
/**
 *
 * @author Gabriel
 */
public class ControladorPartidaPoker implements Observador {
    
    
    private VistaPartidaPoker vista;
    private Participante participante;
    private Sistema fachada= Sistema.getInstancia();

    public ControladorPartidaPoker(VistaPartidaPoker vista, Participante participante) {
        this.vista = vista;
        this.participante = participante;
        fachada.agregar(this);
    }


    @Override
    public void actualizar(Object evento, Observable origen) {
        
    }
}
