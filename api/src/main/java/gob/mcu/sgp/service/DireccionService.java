package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Direccion;
import gob.mcu.sgp.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private MessageSource messageSource;

    public Boolean existeById( Long id) {
        if(id != null && id > 0){
            return direccionRepository.existsById( id );
        }

        throw new RuntimeException( messageSource.getMessage( "error.existById", null, Locale.ENGLISH) );
    }

    public Direccion findById( Long id ) {
        if( id != null && id > 0) {
            return direccionRepository.findById( id ).get();
        }

        throw new RuntimeException( messageSource.getMessage( "error.findById", null, Locale.ENGLISH) );
    }

    public List<Direccion> findAll() {
        return (List<Direccion>) direccionRepository.findAll();
    }

    @Transactional
    public Direccion save( Direccion direccion) {
        if( !existeById( direccion.getId() )) {
            return direccionRepository.save( direccion );
        }

        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id) {
        if( existeById( id ) ){
            direccionRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Direccion direccion){
        if( existeById( direccion.getId() ) ){
            direccionRepository.delete( direccion );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
