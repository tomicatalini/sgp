package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.DireccionTipo;
import gob.mcu.sgp.repository.DireccionTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DireccionTipoService {

    @Autowired
    private DireccionTipoRepository direccionTipoRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return direccionTipoRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public DireccionTipo findById( Long id ) {
        if( existeById( id ) ) {
            return direccionTipoRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<DireccionTipo> findAll() {
        return (List<DireccionTipo>) direccionTipoRepository.findAll();
    }

    @Transactional
    public DireccionTipo save(DireccionTipo direccionTipo){
        if( !existeById( direccionTipo.getId() ) ){
            return direccionTipoRepository.save( direccionTipo );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            direccionTipoRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( DireccionTipo direccionTipo){
        if( existeById( direccionTipo.getId()) ){
            direccionTipoRepository.delete( direccionTipo );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
