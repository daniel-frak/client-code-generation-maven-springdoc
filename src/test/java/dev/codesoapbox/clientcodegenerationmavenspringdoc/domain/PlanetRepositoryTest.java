package dev.codesoapbox.clientcodegenerationmavenspringdoc.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlanetRepositoryTest {

    private PlanetRepository planetRepository;

    @BeforeEach
    void setUp() {
        planetRepository = new PlanetRepository();
    }

    @Test
    void shouldFindAll() {
        var result = planetRepository.findAll();

        assertFalse(result.isEmpty());
    }

    @Test
    void shouldFindById() {
        var expectedPlanet = new Planet(1L, "Omicron Persei 8", true);
        var result = planetRepository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(expectedPlanet, result.get());
    }

    @Test
    void shouldSave() {
        var newPlanet = new Planet(10L, "Desertsia", true);

        Planet saved = planetRepository.save(newPlanet);
        Optional<Planet> retrieved = planetRepository.findById(10L);

        assertEquals(newPlanet, saved);
        assertTrue(retrieved.isPresent());
        assertEquals(newPlanet, retrieved.get());
    }
}