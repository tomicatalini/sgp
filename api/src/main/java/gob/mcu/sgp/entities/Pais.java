package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pais", schema="sgp")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<Persona> personas;

    public Pais() {
    }

    public Pais(Long id, String nombre, List<Persona> personas) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
