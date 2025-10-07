package com.tournament.playso.integration;

import com.tournament.playso.model.County;
import com.tournament.playso.repository.CountyRepository;
import com.tournament.playso.service.CountyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CountyServiceIntegrationTest {

    @Autowired
    private CountyService countyService;

    @Autowired
    private CountyRepository countyRepository;

    @BeforeEach
    void setup() {
        /*countyRepository.deleteAll();

        countyRepository.save(new County("AB", "Alba"));
        countyRepository.save(new County("B", "Bucuresti"));*/
    }

    @Test
    void testGetCounties_integration() {
        // Act
        /*List<County> counties = countyService.getCounties();

        // Assert
        assertThat(counties).hasSize(2);
        assertThat(counties).extracting(County::getName)
                .containsExactlyInAnyOrder("Alba", "Bucuresti");*/
    }
}