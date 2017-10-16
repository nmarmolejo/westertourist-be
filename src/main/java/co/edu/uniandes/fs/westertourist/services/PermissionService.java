package co.edu.uniandes.fs.westertourist.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.fs.westertourist.domain.Permission;
import co.edu.uniandes.fs.westertourist.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(PermissionService.class);
	
    public List<Permission> getPermissions() {
		LOGGER.info("Processing get permissions request");
		
		List<Permission> result = permissionRepository.findAll();
		
		LOGGER.info(result.size() + " records fetched");
		
		return result;
	}
	
    public Permission getPermission(Integer id) {
		LOGGER.info("Processing get permission request with id " + id);
		
		Permission result = permissionRepository.findById(id);
		if (result == null) 
			LOGGER.info("No records founds for id " + id);
		
		return result;
	}
}
