package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Pais;
import gob.mcu.sgp.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return paisRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public Pais findById(Long id ) {
        if( existeById( id ) ) {
            return paisRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<Pais> findAll() {
        return (List<Pais>) paisRepository.findAll();
    }

    @Transactional
    public Pais save(Pais pais){
        if( !existeById( pais.getId() ) ){
            return paisRepository.save( pais );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            paisRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Pais pais){
        if( existeById( pais.getId()) ){
            paisRepository.delete( pais );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
