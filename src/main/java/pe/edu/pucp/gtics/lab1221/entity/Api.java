package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.Entity;

public class Api {

    private String response;
    private Usuario usuario;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
