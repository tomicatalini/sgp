package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.RolPersona;
import gob.mcu.sgp.entities.RolPersonaKey;
import gob.mcu.sgp.repository.RolPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RolPersonaService {

    @Autowired
    private RolPersonaRepository rolPersonaRepository;

    public Boolean existeById( RolPersonaKey id ) {
        if( id != null ){
            return rolPersonaRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public RolPersona findById( RolPersonaKey id ) {
        if( existeById( id ) ) {
            return rolPersonaRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<RolPersona> findAll() {
        return (List<RolPersona>) rolPersonaRepository.findAll();
    }

    @Transactional
    public RolPersona save(RolPersona rolPersona){
        if( !existeById( rolPersona.getId() ) ){
            return rolPersonaRepository.save( rolPersona );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( RolPersonaKey id ) {
        if( existeById( id ) ){
            rolPersonaRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( RolPersona rolPersona){
        if( existeById( rolPersona.getId()) ){
            rolPersonaRepository.delete( rolPersona );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
