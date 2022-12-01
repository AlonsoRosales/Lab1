package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Rol {

    private int idrol;
    private String rol;

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
