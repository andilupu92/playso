package com.tournament.playso.dto;

import com.tournament.playso.model.County;
import com.tournament.playso.model.SportType;
import java.util.List;

public record CountySportDto(List<County> countyList, List<SportType> sportList) {
}
