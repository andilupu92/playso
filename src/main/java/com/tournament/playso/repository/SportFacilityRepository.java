package com.tournament.playso.repository;

import com.tournament.playso.model.County;
import com.tournament.playso.model.SportFacility;
import com.tournament.playso.model.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportFacilityRepository extends JpaRepository<SportFacility, Integer> {

    @Query("SELECT sf FROM SportFacility sf WHERE sf.county = :county AND sf.sportType = :sportType")
    List<SportFacility> findByCountyAndSportType(
            @Param("county") County county,
            @Param("sportType") SportType sportT);
}
