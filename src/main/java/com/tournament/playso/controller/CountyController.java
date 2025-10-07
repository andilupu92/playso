package com.tournament.playso.controller;

import com.tournament.playso.dto.CountySportDto;
import com.tournament.playso.model.County;
import com.tournament.playso.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountyController {

    @Autowired
    CountyService countyService;

    @GetMapping("/countiesAndSports")
    public ResponseEntity<CountySportDto> getCountiesAndSports() {
        return new ResponseEntity<>(countyService.getCountiesAndSports(), HttpStatus.OK);
    }

    @PostMapping("/county")
    public ResponseEntity<County> addCounty(@RequestBody County county) {
        return countyService.addCounty(county);
    }

}
