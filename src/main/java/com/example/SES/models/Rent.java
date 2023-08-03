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
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String ownerEmail;

    @NotBlank
    private String date;

    @NotBlank
    private String number;

    @NotBlank
    private String noMonth;

    public Rent(Long ID,String email1, String email2, String date, String id, String month) {
        this.id=ID;
        this.email = email1;
        this.ownerEmail = email2;
        this.date = date;
        this.number = id;
        this.noMonth = month;
    }
}
