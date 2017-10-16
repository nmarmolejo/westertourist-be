package co.edu.uniandes.fs.westertourist.repository;

import org.springframework.stereotype.Repository;
import co.edu.uniandes.fs.westertourist.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Rol findById(int id);
	
}
