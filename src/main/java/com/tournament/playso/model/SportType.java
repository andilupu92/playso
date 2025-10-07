package com.tournament.playso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sports")
public class SportType {

    @Id
    private String code;
    private String name;

    public SportType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
