package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Rol;
import gob.mcu.sgp.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return rolRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public Rol findById(Long id ) {
        if( existeById( id ) ) {
            return rolRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Transactional
    public Rol save(Rol rol){
        if( !existeById( rol.getId() ) ){
            return rolRepository.save( rol );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            rolRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( Rol rol){
        if( existeById( rol.getId()) ){
            rolRepository.delete( rol );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
