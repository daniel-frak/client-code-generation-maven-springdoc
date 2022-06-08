package dev.codesoapbox.clientcodegenerationmavenspringdoc.controllers;

import dev.codesoapbox.clientcodegenerationmavenspringdoc.domain.Planet;
import dev.codesoapbox.clientcodegenerationmavenspringdoc.domain.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlanetController.class)
class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetRepository repository;

    @Test
    void shouldFindAllPlanets() throws Exception {
        var planet = new Planet(1L, "someName", true);
        when(repository.findAll())
                .thenReturn(Collections.singletonList(planet));

        var expectedJson = """
                [{
                    "id" : 1,
                    "name" : "someName",
                    "isHabitable" : true
                }]
                """;

        mockMvc.perform(get("/planets"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldFindPlanet() throws Exception {
        var planet = new Planet(1L, "someName", true);
        when(repository.findById(1L))
                .thenReturn(Optional.of(planet));

        var expectedJson = """
                {
                    "id" : 1,
                    "name" : "someName",
                    "isHabitable" : true
                }
                """;

        mockMvc.perform(get("/planets/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldSavePlanet() throws Exception {
        var planet = new Planet(1L, "someName", true);

        var planetJson = """
                {
                    "id" : 1,
                    "name" : "someName",
                    "isHabitable" : true
                }
                """;

        when(repository.save(planet))
                .thenReturn(planet);

        mockMvc.perform(post("/planets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(planetJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(planetJson));
    }
}