package com.example.ses.payload;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellFurniturePayLoad {


    @NotBlank
    private String email;

    private String type;
    private String description;
    private String price;
    private String phone;


    @Min(1)
    private String number;

    private List<String> images;

}
