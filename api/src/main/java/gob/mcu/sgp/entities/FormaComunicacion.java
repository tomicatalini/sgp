package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "forma_comunicacion", schema = "sgp")
public class FormaComunicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "forma_comunicacion_tipo_id")
    private FormaComunicacionTipo formaComunicacionTipo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public FormaComunicacion() {
    }

    public FormaComunicacion(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, FormaComunicacionTipo formaComunicacionTipo, Persona persona) {
        Id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.formaComunicacionTipo = formaComunicacionTipo;
        this.persona = persona;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public FormaComunicacionTipo getFormaComunicacionTipo() {
        return formaComunicacionTipo;
    }

    public void setFormaComunicacionTipo(FormaComunicacionTipo formaComunicacionTipo) {
        this.formaComunicacionTipo = formaComunicacionTipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
