package co.edu.uniandes.fs.westertourist.api.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uniandes.fs.westertourist.domain.Rol;
import co.edu.uniandes.fs.westertourist.services.RolService;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {
    
    private static final Logger LOGGER = LogManager.getLogger(RolesController.class);
    
    @Autowired
    private RolService rolService;
    
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Rol>> getRoles() {
        LOGGER.info("Processing get roles request");
        List<Rol> roles = rolService.getRoles();
        
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<?> getRol(@PathVariable Integer id) {
        LOGGER.info("Processing get rol request with id " + id);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        Rol rol = rolService.getRol(id);
        
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<?> addRol(@RequestBody Rol rol) {
        LOGGER.info("Processing add rol request");
        LOGGER.debug("Rol entity: " + rol.toString());
        
        String errorMessage = validateForInsert(rol);
        if (errorMessage != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Rol addedRol = rolService.addRol(rol);
        if (addedRol == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to insert the rol");
        }
        
        return new ResponseEntity<>(addedRol, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PATCH, produces = {"application/json"})
    public ResponseEntity<?> updateRol(@RequestBody Rol rol) {
        LOGGER.info("Processing update rol request");
        LOGGER.debug("Rol entity: " + rol.toString());
        String errorMessage = validateForUpdate(rol);
        if (errorMessage != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Rol updateRol = rolService.addRol(rol);
        
        return new ResponseEntity<>(updateRol, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<?> deleteRol(@PathVariable Integer id) {
        LOGGER.info("Processing delete rol request with id " + id);
        
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        boolean result = rolService.deleteRol(id);
        
        if (!result) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete rol with id " + id);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private String validateForInsert(Rol rol) {
        return null;
    }
    
    private String validateForUpdate(Rol rol) {
        return null;
    }

}
