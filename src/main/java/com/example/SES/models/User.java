package com.example.SES.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
public class User {

    @Id
    @NotBlank
    private String email;

    @NotBlank

    private String password;




    @NotBlank

    private String firstName;

    @NotBlank

    private String lastName;


    @NotBlank

    private String phoneNumber;



    @NotBlank

    private String alternatePhoneNumber;


    @NotBlank

    private String universityMajor;


    @NotBlank

    private String workPlace;



    private int age;




    private int userType;


    public User(String email, String password, String firstName, String lastName, String phoneNumber, String alternatePhoneNumber, String universityMajor, String workPlace, int age, int userType) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.universityMajor = universityMajor;
        this.workPlace = workPlace;
        this.age = age;
        this.userType = userType;
    }

}
