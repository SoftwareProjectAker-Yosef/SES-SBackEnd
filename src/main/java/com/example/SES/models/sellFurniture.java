package com.example.SES.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
public class sellFurniture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String email;






    @NotBlank
    private String type;

    @NotBlank
    private String description;

    @NotBlank
    private String price;


    @NotBlank
    private String phone;

    @Min(1)
    private String number;

    @ElementCollection
    private List<String> images;


    public sellFurniture(Long ID,String email, String Type,String description, String price, String phone,String number,List<String> images) {
        this.id=ID;
        this.email = email;
        this.type=Type;
        this.description=description;
        this.price=price;
        this.phone=phone;
        this.number=number;
        this.images=images;
    }


}
