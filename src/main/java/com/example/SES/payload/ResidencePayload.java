package com.example.SES.payload;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidencePayload {


    private String ownerEmail;

    private String price;

    private String location;

    @Min(1)
    private int floorCount;

    private List<String> services;

    private List<String> images;




}