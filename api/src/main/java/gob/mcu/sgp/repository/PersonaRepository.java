package gob.mcu.sgp.repository;

import gob.mcu.sgp.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
