package yasmingv.sw_planet_api.domain.respository;

import org.springframework.data.repository.CrudRepository;
import yasmingv.sw_planet_api.domain.entity.Planet;

public interface PlanetRepository extends CrudRepository <Planet, Long> {
}
