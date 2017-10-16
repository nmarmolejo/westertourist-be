package co.edu.uniandes.fs.westertourist.repository;

import co.edu.uniandes.fs.westertourist.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findById(int id);

}
