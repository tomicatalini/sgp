package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Calle;
import gob.mcu.sgp.repository.CalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
public class CalleService {

    @Autowired
    private CalleRepository calleRepository;

    @Autowired
    private MessageSource messageSource;

    public Boolean existsById(Long id){

        if(id != null && id > 0){
            return calleRepository.existsById(id);
        }
        throw new RuntimeException(messageSource.getMessage("error.existById", null , Locale.ENGLISH));
    }

    public Calle findById(Long id){

        if( existsById(id) ){
            return calleRepository.findById(id).get();
        }

        throw new RuntimeException(messageSource.getMessage("error.findById", null , Locale.ENGLISH));
    }

    public List<Calle> findAll(){
        return (List<Calle>) calleRepository.findAll();
    }

    @Transactional
    public Calle Save(Calle calle){

        if( !existsById( calle.getId() ) ){
            return calleRepository.save( calle );
        }

        throw new RuntimeException(messageSource.getMessage("error.save", null , Locale.ENGLISH));
    }

    @Transactional
    public Boolean delete(Calle calle){
        if( existsById( calle.getId() ) ){
            calleRepository.delete( calle );
            return Boolean.TRUE;
        }
        throw new RuntimeException( messageSource.getMessage("error.delete", new String[]{this.getClass().getName()} , Locale.ENGLISH));
    }

    @Transactional
    public Boolean deleteById(Long id){
        if( existsById(id) ){
            calleRepository.deleteById( id );
            return Boolean.TRUE;
        }
        throw new RuntimeException( messageSource.getMessage("error.delete", new String[]{this.getClass().getName()} , Locale.ENGLISH));
    }
}
