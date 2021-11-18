/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Objects;

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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenha, other.contrasenha)) {
            return false;
        }
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }
    
    
    
    
    
    
    
}
