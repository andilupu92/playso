package com.tournament.playso.service;

import com.tournament.playso.dto.CountySportDto;
import com.tournament.playso.model.County;
import com.tournament.playso.model.SportType;
import com.tournament.playso.repository.CountyRepository;
import com.tournament.playso.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {

    @Autowired
    CountyRepository countyRepository;
    @Autowired
    SportRepository sportRepository;

    public CountySportDto getCountiesAndSports() {

        List<County> counties = countyRepository.findAll();
        List<SportType> sports = sportRepository.findAll();

        return new CountySportDto(counties, sports);
    }

    public ResponseEntity<County> addCounty(County county) {
        return new ResponseEntity<>(countyRepository.save(county), HttpStatus.CREATED);
    }
}
