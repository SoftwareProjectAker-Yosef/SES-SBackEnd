package com.example.ses.payload;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentPayload {


    @NotBlank
    private String email;

    private String ownerEmail;
    private String date;
    private String number;


}
