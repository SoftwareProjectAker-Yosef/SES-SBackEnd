package com.example.ses.models;


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
public class SellFurniture {

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


    public SellFurniture(Long id1,String email, String type,String description, String price, String phone,String number,List<String> images) {
        this.id=id1;
        this.email = email;
        this.type=type;
        this.description=description;
        this.price=price;
        this.phone=phone;
        this.number=number;
        this.images=images;
    }


}
