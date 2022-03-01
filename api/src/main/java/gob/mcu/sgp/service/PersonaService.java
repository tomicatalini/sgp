package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Persona;
import gob.mcu.sgp.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return personaRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public Persona findById(Long id ) {
        if( existeById( id ) ) {
            return personaRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Transactional
    public Persona save(Persona persona){
        if( !existeById( persona.getId() ) ){
            return personaRepository.save( persona );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            personaRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Persona persona){
        if( existeById( persona.getId()) ){
            personaRepository.delete( persona );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
