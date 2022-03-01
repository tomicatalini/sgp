package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.FormaComunicacionTipo;
import gob.mcu.sgp.repository.FormaComunicacionTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FormaComunicacionTipoService {

    @Autowired
    private FormaComunicacionTipoRepository formaComunicacionTipoRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return formaComunicacionTipoRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public FormaComunicacionTipo findById(Long id ) {
        if( existeById( id ) ) {
            return formaComunicacionTipoRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<FormaComunicacionTipo> findAll() {
        return (List<FormaComunicacionTipo>) formaComunicacionTipoRepository.findAll();
    }

    @Transactional
    public FormaComunicacionTipo save(FormaComunicacionTipo formaComunicacionTipo){
        if( !existeById( formaComunicacionTipo.getId() ) ){
            return formaComunicacionTipoRepository.save( formaComunicacionTipo );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            formaComunicacionTipoRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( FormaComunicacionTipo formaComunicacionTipo){
        if( existeById( formaComunicacionTipo.getId()) ){
            formaComunicacionTipoRepository.delete( formaComunicacionTipo );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
