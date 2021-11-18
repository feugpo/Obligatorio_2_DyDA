/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.ArrayList;
import logica.Carta;
import logica.Juego;
import logica.Participante;

/**
 *
 * @author Gabriel
 */
public interface VistaPartidaPoker {

    public void cargarVistaParticipante(Participante p);

    public void alertarApuesta(String apostardor, int monto);

    public void mostrarDatos(String titulo, int saldo);

    public void mostrarCartas(ArrayList<String> cartas);

    public void mensajeListaEspera(int faltantes);

    public void mensajeMano(String nomFigura, String cartaAlta);

    public void habilitarBotones();

    public void inhabilitarBotones();

    public void vaciarMensaje();

    public void consultarSiContinua();

    public void avisarNoContinua();
    
    public void cerrarVista();

    public void informarSobreGanadorRonda(String nombreUsu, String figura);

    public void mostrarJugadores(ArrayList<String> participantes);

    public void mostrarPozo(int monto);

    public void avisarGanadorJuego(String nombreUsu);

    

}
