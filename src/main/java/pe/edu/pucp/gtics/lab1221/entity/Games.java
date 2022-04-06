package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.*;

@Entity
@Table(name = "juegos")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idgenero")
    private Integer idgenero;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idplataforma")
    private Integer idplataforma;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ideditora")
    private Integer ideditora;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "iddistribuidora")
    private Integer iddistribuidora;

    public Integer getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(Integer iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
    }

    public Integer getIdeditora() {
        return ideditora;
    }

    public void setIdeditora(Integer ideditora) {
        this.ideditora = ideditora;
    }

    public Integer getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(Integer idplataforma) {
        this.idplataforma = idplataforma;
    }

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}