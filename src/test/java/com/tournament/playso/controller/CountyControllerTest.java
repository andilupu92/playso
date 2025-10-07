package com.tournament.playso.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.tournament.playso.dto.CountySportDto;
import com.tournament.playso.model.County;
import com.tournament.playso.model.SportType;
import com.tournament.playso.service.CountyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(CountyController.class)
class CountyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CountyService countyService;

    @Test
    void testGetCounties() throws Exception {
        // Arrange
        County county1 = new County("CJ", "Cluj");
        County county2 = new County("IS", "Iași");
        SportType sport1 = new SportType("F", "Football");
        SportType sport2 = new SportType("V", "Volleyball");
        List<County> counties = List.of(county1, county2);
        List<SportType> sports = List.of(sport1, sport2);
        when(countyService.getCountiesAndSports()).thenReturn(new CountySportDto(counties, sports));

        // Act & Assert
        mockMvc.perform(get("/api/countiesAndSports"))
                .andExpect(status().isOk());
                /*.andExpect(jsonPath("$[0].name").value("Cluj"))
                .andExpect(jsonPath("$[1].name").value("Iași"));*/
    }
}