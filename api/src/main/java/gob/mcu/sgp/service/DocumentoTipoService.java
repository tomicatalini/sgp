package gob.mcu.sgp.service;

import gob.mcu.sgp.entities.DocumentoTipo;
import gob.mcu.sgp.repository.DocumentoTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentoTipoService {
    
    @Autowired
    private DocumentoTipoRepository documentoTipoRepository;

    public Boolean existeById( Long id ) {
        if(id != null && id > 0){
            return documentoTipoRepository.existsById( id );
        }
        throw new RuntimeException();
    }

    public DocumentoTipo findById(Long id ) {
        if( existeById( id ) ) {
            return documentoTipoRepository.findById( id ).get();
        }
        throw new RuntimeException();
    }

    public List<DocumentoTipo> findAll() {
        return (List<DocumentoTipo>) documentoTipoRepository.findAll();
    }

    @Transactional
    public DocumentoTipo save(DocumentoTipo documentoTipo){
        if( !existeById( documentoTipo.getId() ) ){
            return documentoTipoRepository.save( documentoTipo );
        }
        throw new RuntimeException();
    }

    @Transactional
    public Boolean deleteById( Long id ) {
        if( existeById( id ) ){
            documentoTipoRepository.deleteById( id );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional
    public Boolean delete( DocumentoTipo documentoTipo){
        if( existeById( documentoTipo.getId()) ){
            documentoTipoRepository.delete( documentoTipo );
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
