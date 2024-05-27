package yasmingv.sw_planet_api.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static yasmingv.sw_planet_api.common.PlanetConstants.PLANET;

import yasmingv.sw_planet_api.domain.entity.Planet;
import yasmingv.sw_planet_api.domain.respository.PlanetRepository;
import yasmingv.sw_planet_api.domain.service.PlanetService;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    @Test
    public void createPlanet_WithValidData_ReturnPlanet() {
       when(planetRepository.save(PLANET)).thenReturn(PLANET);

       Planet sut = planetService.create(PLANET);

       assertThat(sut).isEqualTo(PLANET);
    }
}
