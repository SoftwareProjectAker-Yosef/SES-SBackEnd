package com.example.SES.controller;


import com.example.SES.models.sellFurniture;
import com.example.SES.payload.sellFurniturePayLoad;


import com.example.SES.repository.sellFurnitureRepo;
import com.example.SES.services.sellFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fur")
@CrossOrigin(originPatterns = "*")

public class sellFurnitureContorller {

    @Autowired
    private sellFurnitureService furSer;
    @Autowired
    private sellFurnitureRepo furRepo;

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
    ResponseEntity<List<sellFurniture>> getFurnitureByType(@RequestParam String type) {
        List<sellFurniture> furnitureList = furSer.getFurnitureByType(type);
        return ResponseEntity.ok(furnitureList);
    }


    @PostMapping( value="/saveFur",consumes = {"application/json"})
    public @ResponseBody ResponseEntity<?> addFurToDb(@RequestBody sellFurniturePayLoad FurPayLoad) {
        furSer.addFur(
                sellFurniture.builder()
                        .email(FurPayLoad.getEmail())
                        .type(FurPayLoad.getType())
                        .description(FurPayLoad.getDescription())
                        .price(FurPayLoad.getPrice())
                        .phone(FurPayLoad.getPhone())
                        .number(FurPayLoad.getNumber())
                        .images(FurPayLoad.getImages())
                        .build()
        );

        return ResponseEntity.accepted().build();
    }

}
