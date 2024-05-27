package yasmingv.sw_planet_api.domain.respository;

import org.springframework.data.repository.CrudRepository;
import yasmingv.sw_planet_api.domain.entity.Planet;

import java.util.Optional;

public interface PlanetRepository extends CrudRepository <Planet, Long> {
    Optional<Planet> findByName(String name);
}
