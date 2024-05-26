package yasmingv.sw_planet_api.domain.service;


import org.springframework.stereotype.Service;
import yasmingv.sw_planet_api.domain.entity.Planet;
import yasmingv.sw_planet_api.domain.respository.PlanetRepository;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }
}
