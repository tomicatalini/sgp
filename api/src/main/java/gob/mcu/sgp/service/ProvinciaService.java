package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Provincia;
import gob.mcu.sgp.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return provinciaRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public Provincia findById(Long id ) {
        if( existeById( id ) ) {
            return provinciaRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<Provincia> findAll() {
        return (List<Provincia>) provinciaRepository.findAll();
    }

    @Transactional
    public Provincia save(Provincia provincia){
        if( !existeById( provincia.getId() ) ){
            return provinciaRepository.save( provincia );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            provinciaRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Provincia provincia){
        if( existeById( provincia.getId()) ){
            provinciaRepository.delete( provincia );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
