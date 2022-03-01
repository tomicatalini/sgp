package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.PersonaTipo;
import gob.mcu.sgp.repository.PersonaTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonaTipoService {

    @Autowired
    private PersonaTipoRepository personaTipoRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return personaTipoRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public PersonaTipo findById(Long id ) {
        if( existeById( id ) ) {
            return personaTipoRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<PersonaTipo> findAll() {
        return (List<PersonaTipo>) personaTipoRepository.findAll();
    }

    @Transactional
    public PersonaTipo save(PersonaTipo personaTipo){
        if( !existeById( personaTipo.getId() ) ){
            return personaTipoRepository.save( personaTipo );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            personaTipoRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( PersonaTipo personaTipo){
        if( existeById( personaTipo.getId()) ){
            personaTipoRepository.delete( personaTipo );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
