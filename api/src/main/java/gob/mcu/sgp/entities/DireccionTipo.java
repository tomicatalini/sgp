package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "direccion_tipo", schema = "sgp")
public class DireccionTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 120, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "direccionTipo")
    private List<Direccion> direcciones;

    public DireccionTipo() {
    }

    public DireccionTipo(Long id, String nombre, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
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
}
