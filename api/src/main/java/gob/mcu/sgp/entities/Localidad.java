package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "localidad", schema = "sgp")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 120, nullable = false)
    private String nombre;
    @Column(length = 4, nullable = false)
    private String codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @OneToMany(mappedBy = "localidad")
    private List<Direccion> direcciones;

    public Localidad() {
    }

    public Localidad(Long id, String nombre, String codigoPostal, Provincia provincia, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
}
