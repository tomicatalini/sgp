package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.Calle;
import gob.mcu.sgp.repository.CalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

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

    public List<Calle> findAll(Integer page, Integer perPage, Optional<String> sortBy, Optional<String> sortDir){
        if(page != null && perPage != null){
            Pageable pageable = null;
            Sort sort = null;

            if( !sortBy.isPresent() ){
                pageable = PageRequest.of(page, perPage);

            } else {

                if( sortDir.isPresent() ){
                    sort = sortDir.get().equalsIgnoreCase("asc") ? Sort.by( sortBy.get() ).ascending() : Sort.by( sortBy.get() ).descending();
                } else {
                    sort = Sort.by( sortBy.get() );
                }
                pageable = PageRequest.of(page, perPage, sort);
            }

            return calleRepository.findAll( pageable ).getContent();
        }
        throw new RuntimeException();
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
    public Calle save(Calle calle){

        if( !existsById( calle.getId() ) ){
            return calleRepository.save( calle );
        }

        throw new RuntimeException(messageSource.getMessage("error.save", null , Locale.ENGLISH));
    }

    @Transactional
    public Calle update(Long id, Calle calle){

        if( existsById( id ) ){
            Calle oldCalle = calleRepository.findById( id ).get();
            if(calle.getNombre() != null){
                oldCalle.setNombre( calle.getNombre() );
            }
            return calleRepository.save( oldCalle );
        }

        throw new RuntimeException(messageSource.getMessage("error.save", null , Locale.ENGLISH));
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
