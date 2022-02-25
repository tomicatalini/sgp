package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provincia", schema = "sgp")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 120, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    private List<Localidad> localidades;

    public Provincia() {
    }

    public Provincia(Long id, String nombre, Pais pais, List<Localidad> localidades) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.localidades = localidades;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }
}
