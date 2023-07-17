
package com.example.SES.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {


    @NotBlank
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private String universityMajor;
    private String workPlace;
    private int age;
    private int userType;





}