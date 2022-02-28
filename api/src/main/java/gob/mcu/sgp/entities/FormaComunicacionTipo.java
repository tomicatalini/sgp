package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forma_comunicacion_tipo", schema = "sgp")
public class FormaComunicacionTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "formaComunicacionTipo", fetch = FetchType.LAZY)
    private List<FormaComunicacion> formaComunicacionList;

    public FormaComunicacionTipo() {
    }

    public FormaComunicacionTipo(Long id, String nombre, List<FormaComunicacion> formaComunicacionList) {
        this.id = id;
        this.nombre = nombre;
        this.formaComunicacionList = formaComunicacionList;
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

    public List<FormaComunicacion> getFormaComunicacionList() {
        return formaComunicacionList;
    }

    public void setFormaComunicacionList(List<FormaComunicacion> formaComunicacionList) {
        this.formaComunicacionList = formaComunicacionList;
    }
}
