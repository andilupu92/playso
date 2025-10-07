package com.tournament.playso.service;

import com.tournament.playso.model.County;
import com.tournament.playso.model.SportFacility;
import com.tournament.playso.model.SportType;
import com.tournament.playso.repository.SportFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportFacilityService {

    @Autowired
    SportFacilityRepository sportFacilityRepository;

    public List<SportFacility> findByCountyAndSportType(String countyCode, String sportType) {
        County county = new County();
        county.setCode(countyCode);
        SportType sportT = new SportType();
        sportT.setCode(sportType);
        return sportFacilityRepository.findByCountyAndSportType(county, sportT);
    }

    public ResponseEntity<SportFacility> addFacility(SportFacility sportFacility) {
        return new ResponseEntity<>(sportFacilityRepository.save(sportFacility), HttpStatus.CREATED);
    }
}
