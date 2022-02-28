package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol", schema = "sgp")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "rol")
    private List<RolPersona> rolPersonas;

    public Rol() {
    }

    public Rol(Long id, String nombre, List<RolPersona> rolPersonas) {
        this.id = id;
        this.nombre = nombre;
        this.rolPersonas = rolPersonas;
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

    public List<RolPersona> getRolPersonas() {
        return rolPersonas;
    }

    public void setRolPersonas(List<RolPersona> rolPersonas) {
        this.rolPersonas = rolPersonas;
    }
}
