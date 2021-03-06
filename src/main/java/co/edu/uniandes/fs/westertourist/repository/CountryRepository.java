package co.edu.uniandes.fs.westertourist.repository;

import co.edu.uniandes.fs.westertourist.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findById(int id);

}
