package co.edu.uniandes.fs.westertourist.repository;

import org.springframework.stereotype.Repository;

import co.edu.uniandes.fs.westertourist.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	
	Permission findById(int id);
	
}
