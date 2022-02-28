package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona_tipo", schema = "sgp")
public class PersonaTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "personaTipo")
    private List<Persona> personas;

    public PersonaTipo() {
    }

    public PersonaTipo(Long id, String nombre, List<Persona> personas) {
        Id = id;
        this.nombre = nombre;
        this.personas = personas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
