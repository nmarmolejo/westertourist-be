package co.edu.uniandes.fs.westertourist.repository;

import co.edu.uniandes.fs.westertourist.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    Provider findById(int id);

}
