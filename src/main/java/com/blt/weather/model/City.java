package com.blt.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author fatih
 */
@Data
@ToString
@Entity
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
