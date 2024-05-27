package yasmingv.sw_planet_api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yasmingv.sw_planet_api.domain.Planet;
import yasmingv.sw_planet_api.domain.PlanetService;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create (@RequestBody Planet planet) {
        Planet planetCreated = planetService.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getById(@PathVariable("id") Long id) {
       return planetService.getById(id).map(planet -> ResponseEntity.ok(planet))
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Planet> getByName(@PathVariable("name") String name) {
        return planetService.getByName(name).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Planet>> getAll(@RequestParam(required = false) String terrain,
           @RequestParam(required = false) String climate) {
        List<Planet> planets = planetService.getAll(terrain, climate);
        return ResponseEntity.ok(planets);
    }
}

