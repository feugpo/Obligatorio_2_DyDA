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
public class Jugador extends Usuario {
    private int saldo;

    public Jugador(String nombreUsuario, String contrasenha, String nombreCompleto, int saldo) {
        super(nombreUsuario, contrasenha, nombreCompleto);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    void cobrar(int monto) {
        saldo += monto;
    }

    void pagar(int monto) {
        saldo -= monto;
    }
    
  
    
    

    

    
    
    
}
