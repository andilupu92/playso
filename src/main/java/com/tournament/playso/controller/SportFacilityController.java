package com.tournament.playso.controller;

import com.tournament.playso.model.SportFacility;
import com.tournament.playso.model.SportType;
import com.tournament.playso.service.SportFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportFacilityController {

    @Autowired
    SportFacilityService sportFacilityService;

    @GetMapping("/facility")
    public ResponseEntity<List<SportFacility>> findByCountyAndSportType(@RequestParam String countyCode, @RequestParam String sportType) {
        return new ResponseEntity<>(sportFacilityService.findByCountyAndSportType(countyCode, sportType), HttpStatus.OK);
    }

    @PostMapping("/facility")
    public ResponseEntity<SportFacility> addFacility(@RequestBody SportFacility sportFacility) {
        return sportFacilityService.addFacility(sportFacility);
    }

}
