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
    @JsonIgnore
    private Long id;
    @NotBlank
    private String ownerEmail;

    @NotBlank
    private String price;


    @NotBlank
    private String location;

    @Min(1)
    private int floorCount;

    @ElementCollection
    private List <String> services;

    @ElementCollection
    private List<String> images;




    public Residence(Long id, String ownerEmail, String price, String location, int floorCount, List<String> services, List<String> images) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.price = price;
        this.location = location;
        this.floorCount = floorCount;
        this.services = services;
        this.images = images;
    }


}
