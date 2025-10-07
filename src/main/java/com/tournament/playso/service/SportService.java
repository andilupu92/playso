package com.tournament.playso.service;

import com.tournament.playso.model.SportType;
import com.tournament.playso.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    @Autowired
    SportRepository sportRepository;

    public ResponseEntity<SportType> addSport(SportType sportType) {
        return new ResponseEntity<>(sportRepository.save(sportType), HttpStatus.CREATED);
    }
}
