package gob.mcu.sgp.controller;

import gob.mcu.sgp.entities.Calle;
import gob.mcu.sgp.service.CalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("calle")
public class CalleController {

    @Autowired
    private CalleService calleService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> findAll(){
        List<Calle> calles = null;
        Map<String, Object> response = new HashMap<>();

        try{
            calles = calleService.findAll();
        } catch (DataAccessException dataAccessException){
            response.put("mensaje", "Error al consultar la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException){
            response.put("mensaje", "Los parametros ingresados son incorrectos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("mensaje", "Ups! Algo paso... :(");
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "success");
        response.put("calles", calles);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping(value = {"/filter/{page}/{perPage}", "/filter/{page}/{perPage}/{sortBy}", "/filter/{page}/{perPage}/{sortBy}/{sortDir}"}, produces = "application/json")
    public ResponseEntity<?> findAll(@PathVariable Integer page, @PathVariable Integer perPage, @PathVariable Optional<String> sortBy, @PathVariable Optional<String> sortDir){
        List<Calle> calles = null;
        Map<String, Object> response = new HashMap<>();

        try{
            calles = calleService.findAll(page, perPage, sortBy, sortDir);
        } catch (DataAccessException dataAccessException){
            response.put("mensaje", "Error al consultar la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException){
            response.put("mensaje", "Los parametros ingresados son incorrectos");
            runtimeException.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("mensaje", "Ups! Algo paso... :(");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "success");
        response.put("calles", calles);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> save(@RequestBody Calle calle){
        Calle newCalle = null;
        Map<String, Object> response = new HashMap<>();

        try{
            newCalle = calleService.save( calle );
        } catch (DataAccessException dataAccessException){
            response.put("mensaje", "Error al consultar la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException){
            response.put("mensaje", "Los parametros ingresados son incorrectos");
            runtimeException.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("mensaje", "Ups! Algo paso... :(");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "success");
        response.put("calle", newCalle);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Calle calle){
        Calle newCalle = null;
        Map<String, Object> response = new HashMap<>();

        try{
            newCalle = calleService.update( id, calle );
        } catch (DataAccessException dataAccessException){
            response.put("mensaje", "Error al consultar la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException){
            response.put("mensaje", "Los parametros ingresados son incorrectos");
            runtimeException.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("mensaje", "Ups! Algo paso... :(");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "success");
        response.put("calle", newCalle);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Boolean deleted = false;
        Map<String, Object> response = new HashMap<>();

        try{
            deleted = calleService.deleteById( id );
        } catch (DataAccessException dataAccessException){
            response.put("mensaje", "Error al consultar la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException){
            response.put("mensaje", "Los parametros ingresados son incorrectos");
            runtimeException.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("mensaje", "Ups! Algo paso... :(");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "success");
        response.put("deleted", deleted);
        return new ResponseEntity<Map<String, Object>>( response, HttpStatus.OK);
    }

}
