package com.tournament.playso.repository;

import com.tournament.playso.model.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<SportType, String> {
}
