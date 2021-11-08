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
public abstract class Usuario {
    private String nombreUsuario;
    private String contrasenha;
    private String nombreCompleto;

    public Usuario(String nombreUsuario, String contrasenha, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
        this.nombreCompleto = nombreCompleto;
    }

    

    
    
}
