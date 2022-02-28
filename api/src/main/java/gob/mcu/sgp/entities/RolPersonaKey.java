package gob.mcu.sgp.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RolPersonaKey implements Serializable {

    @Column(name = "rol_id")
    private Long rolId;

    @Column(name = "persona_id")
    private Long personaId;

    public RolPersonaKey() {
    }

    public RolPersonaKey(Long rolId, Long personaId) {
        this.rolId = rolId;
        this.personaId = personaId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
}
