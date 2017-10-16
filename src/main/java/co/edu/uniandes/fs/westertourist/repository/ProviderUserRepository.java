package co.edu.uniandes.fs.westertourist.repository;

import co.edu.uniandes.fs.westertourist.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderUserRepository extends JpaRepository<ProviderUser, Integer> {

    ProviderUser findById(int id);

}
