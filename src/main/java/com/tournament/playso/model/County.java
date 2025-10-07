package com.tournament.playso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Data
@Table(name = "counties")
@NoArgsConstructor
@Immutable
public class County {

    @Id
    private String code;
    private String name;

    public County(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
