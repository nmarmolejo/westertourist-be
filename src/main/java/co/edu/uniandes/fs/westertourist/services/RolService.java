package co.edu.uniandes.fs.westertourist.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.fs.westertourist.domain.Rol;
import co.edu.uniandes.fs.westertourist.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(RolService.class);
	
    public List<Rol> getRoles() {
		LOGGER.info("Processing get roles request");
		
		List<Rol> result = rolRepository.findAll();
		
		LOGGER.info(result.size() + " records fetched");
		
		return result;
	}
	
    public Rol getRol(Integer id) {
		LOGGER.info("Processing get rol request with id " + id);
		
		Rol result = rolRepository.findById(id);
		if (result == null) 
			LOGGER.info("No records founds for id " + id);
		
		return result;
	}
	
    public Rol addRol(Rol rol) {
		LOGGER.info("Processing add rol request");
		LOGGER.debug("Rol entity: " + rol.toString());
		
		try {
			Rol savedRol = rolRepository.save(rol);
			if (savedRol == null) 
				LOGGER.error("Unable to insert or update record");
			
			return savedRol;
		} catch (Exception e) {
			LOGGER.error("Cannot insert rol", e);
			return null;
		}
		
	}
	
    public Rol updateRol(Rol rol) {
		LOGGER.info("Processing update rol request");
		LOGGER.debug("Rol entity: " + rol.toString());
		
		return addRol(rol);
	}
	
    public boolean deleteRol(Integer id) {
		LOGGER.info("Processing delete rol request with id " + id);
		
		try {
			rolRepository.delete(id);
		} catch (Exception e) {
			LOGGER.error("Cannot delete rol record for id " + id);
		}
		
		return true;
	}
	
}
