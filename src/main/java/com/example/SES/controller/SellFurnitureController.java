package com.example.SES.controller;


import com.example.SES.models.SellFurniture;

import com.example.SES.payload.SellFurniturePayLoad;



import com.example.SES.repository.SellFurnitureRepo;
import com.example.SES.services.SellFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fur")
@CrossOrigin(originPatterns = "*")

public class SellFurnitureController {

    @Autowired
    private SellFurnitureService furSer;
    @Autowired
    private SellFurnitureRepo furRepo;

    @GetMapping("/getFur")
    public @ResponseBody
    ResponseEntity<?> getAllFur() {
        return ResponseEntity.ok(furSer.getAllFur());
    }

    @GetMapping("/test")
    public @ResponseBody ResponseEntity<?> testGetFur(@RequestParam Long id) {
        return ResponseEntity.ok(furSer.tempGetFur(id));
    }

    @GetMapping("/getFurtype")
    public @ResponseBody
    ResponseEntity<List<SellFurniture>> getFurnitureByType(@RequestParam String type) {
        List<SellFurniture> furnitureList = furSer.getFurnitureByType(type);
        return ResponseEntity.ok(furnitureList);
    }


    @PostMapping( value="/saveFur",consumes = {"application/json"})
    public @ResponseBody ResponseEntity<?> addFurToDb(@RequestBody SellFurniturePayLoad furPayLoad) {
        furSer.addFur(
                SellFurniture.builder()
                        .email(furPayLoad.getEmail())
                        .type(furPayLoad.getType())
                        .description(furPayLoad.getDescription())
                        .price(furPayLoad.getPrice())
                        .phone(furPayLoad.getPhone())
                        .number(furPayLoad.getNumber())
                        .images(furPayLoad.getImages())
                        .build()
        );

        return ResponseEntity.accepted().build();
    }

}
