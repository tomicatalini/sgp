package gob.mcu.sgp.entities;

import javax.persistence.*;

@Entity
@Table(name = "rol_persona", schema = "sgp")
public class RolPersona {

    @EmbeddedId
    private RolPersonaKey id;

    @ManyToOne
    @MapsId("rolId")
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @MapsId("personaId")
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @Column(nullable = false)
    private Long idExterno;

    public RolPersona() {
    }

    public RolPersona(RolPersonaKey id, Rol rol, Persona persona, Long idExterno) {
        this.id = id;
        this.rol = rol;
        this.persona = persona;
        this.idExterno = idExterno;
    }

    public RolPersonaKey getId() {
        return id;
    }

    public void setId(RolPersonaKey id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(Long idExterno) {
        this.idExterno = idExterno;
    }
}
