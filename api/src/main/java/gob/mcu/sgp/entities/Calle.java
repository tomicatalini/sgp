package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="calle", schema="sgp")
public class Calle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "calle")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "entreCallePrimera")
    private List<Direccion> direccionesCallePrimera;

    @OneToMany(mappedBy = "entreCalleSegunda")
    private List<Direccion> direccionesCalleSegunda;

    public Calle() {
    }

    public Calle(Long id, String nombre, List<Direccion> direcciones, List<Direccion> direccionesCallePrimera, List<Direccion> direccionesCalleSegunda) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
        this.direccionesCallePrimera = direccionesCallePrimera;
        this.direccionesCalleSegunda = direccionesCalleSegunda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Direccion> getDireccionesCallePrimera() {
        return direccionesCallePrimera;
    }

    public void setDireccionesCallePrimera(List<Direccion> direccionesCallePrimera) {
        this.direccionesCallePrimera = direccionesCallePrimera;
    }

    public List<Direccion> getDireccionesCalleSegunda() {
        return direccionesCalleSegunda;
    }

    public void setDireccionesCalleSegunda(List<Direccion> direccionesCalleSegunda) {
        this.direccionesCalleSegunda = direccionesCalleSegunda;
    }
}
