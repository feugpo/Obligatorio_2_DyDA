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
public class Participante {
    private Jugador jugador;
    private int saldoInicial;
    private int totalApostado;
    private int totalGanado;
    private Mano mano;

    public Participante(Jugador jugador) {
        this.jugador = jugador;
        this.saldoInicial = jugador.getSaldo();
        
    }

    public Mano getMano() {
        return mano;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int totalApostado) {
        this.totalApostado = totalApostado;
    }
    
    public void sumarApostado(int monto){
        totalApostado += monto; 
    }
    
    public void sumarGanado(int monto){
        totalGanado += monto; 
    }
    //LO PRECISO SI TENGO Q REINICIAR LA MANO PARA CADA NUEVA RONDA
    public void nuevaMano(){       
        this.mano = new Mano();
    }
    
    
    
    
}
