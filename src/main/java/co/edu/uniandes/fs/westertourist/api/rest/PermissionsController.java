package co.edu.uniandes.fs.westertourist.api.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.fs.westertourist.domain.Permission;
import co.edu.uniandes.fs.westertourist.services.PermissionService;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionsController {
	
	private static final Logger LOGGER = LogManager.getLogger(PermissionsController.class);
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Permission>> getPermissions() {
		LOGGER.info("Processing get permissions request");
		List<Permission> permissions = permissionService.getPermissions();
		
		return new ResponseEntity<>(permissions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<?> getPermission(@PathVariable Integer id) {
		LOGGER.info("Processing get permission request with id " + id);
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
		}
		Permission permission = permissionService.getPermission(id);
		
		return new ResponseEntity<>(permission, HttpStatus.OK);
	}

}
