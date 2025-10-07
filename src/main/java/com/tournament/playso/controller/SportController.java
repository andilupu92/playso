package com.tournament.playso.controller;

import com.tournament.playso.model.SportType;
import com.tournament.playso.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SportController {

    @Autowired
    SportService sportService;

    @PostMapping("/sport")
    public ResponseEntity<SportType> addSport(@RequestBody SportType sportType) {
        return sportService.addSport(sportType);
    }
}
