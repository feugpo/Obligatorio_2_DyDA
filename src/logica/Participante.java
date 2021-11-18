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
public class Participante {

    private Jugador jugador;
    private int saldoInicial;
    private int totalApostado;
    private int totalGanado;
    private Mano mano;

    public Participante(Jugador j) {
        jugador = j;
        saldoInicial = 0;
        totalApostado = 0;
        totalGanado = 0;
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
        totalApostado = totalApostado;
    }

    public void setTotalGanado(int totalGanado) {
        totalGanado = totalGanado;
    }

    public void sumarApostado(int monto) {
        totalApostado += monto;
    }

    public void sumarGanado(int monto) {
        totalGanado += monto;
    }

    //LO PRECISO SI TENGO Q REINICIAR LA MANO PARA CADA NUEVA RONDA
    public void nuevaMano() {
        mano = new Mano();
    }

    public void iniciarSaldo() {
        saldoInicial = jugador.getSaldo();
    }

    public boolean comparar(Jugador j) {
        return jugador.equals(j);
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public boolean tieneMano() {
        return getMano() != null;
    }

    public void vaciarMano() {
        this.mano = null;
    }

    public void cobrar(int monto) {
        jugador.cobrar(monto);
    }
    
    public String nombreUsu(){
        return this.jugador.getNombreUsuario();
    }

    @Override
    public String toString() {
        return "Nombre completo: " + jugador.getNombreCompleto() + " Total Apostado: " + totalApostado + " Saldo inicial: " + saldoInicial + " Total Ganado: " + totalGanado;
    }
    
    
    
}
