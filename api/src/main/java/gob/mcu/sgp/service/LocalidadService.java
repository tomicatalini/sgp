package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Localidad;
import gob.mcu.sgp.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return localidadRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public Localidad findById(Long id ) {
        if( existeById( id ) ) {
            return localidadRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<Localidad> findAll() {
        return (List<Localidad>) localidadRepository.findAll();
    }

    @Transactional
    public Localidad save(Localidad localidad){
        if( !existeById( localidad.getId() ) ){
            return localidadRepository.save( localidad );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            localidadRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Localidad localidad){
        if( existeById( localidad.getId()) ){
            localidadRepository.delete( localidad );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
