package com.example.SES.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
public class Residence {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank
    private String ownerEmail;

    @NotBlank
    private String price;

    @NotBlank
    private String description;


    private int area;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String location;

    @Min(1)
    private int floorCount;

    @Min(1)
    private int bathrooms;

    @Min(1)
    private int bedrooms;

    @ElementCollection
    private List <String> services;

    @ElementCollection
    private List<String> images;

    public Residence(Long id, String ownerEmail, String price, String description, int area, String city, String country, String location, int floorCount, int bathrooms, int bedrooms, List<String> services, List<String> images) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.price = price;
        this.description = description;
        this.area = area;
        this.city = city;
        this.country = country;
        this.location = location;
        this.floorCount = floorCount;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.services = services;
        this.images = images;
    }
}
