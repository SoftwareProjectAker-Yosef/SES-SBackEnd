package com.example.SES.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



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



    public Rent(Long id,String email1, String email2, String date, String id2) {
        this.id=id;
        this.email = email1;
        this.ownerEmail = email2;
        this.date = date;
        this.number = id2;

    }
}
