package com.example.SES.controller;

import com.example.SES.models.Residence;
import com.example.SES.repository.ResidenceRepo;
import com.example.SES.payload.ResidencePayload;

import com.example.SES.services.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residence")
@CrossOrigin(originPatterns = "*")
public class ResidenceController {

@Autowired
    private ResidenceService residenceService;


    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<?> getAllResidences() {
        return ResponseEntity.ok(residenceService.getAllResidences());
    }




    @GetMapping("/test")
    public @ResponseBody ResponseEntity<?> testGetResidence(@RequestParam Long id) {
        return ResponseEntity.ok(residenceService.tempGetResidence(id));
    }




    @PostMapping( value="/saveResidence",consumes = {"application/json"})
    public ResponseEntity<?> addResidenceToDb(@RequestBody ResidencePayload residencePayload) {
        Residence residence = Residence.builder()
                .ownerEmail(residencePayload.getOwnerEmail())
                .price(residencePayload.getPrice())
                .location(residencePayload.getLocation())
                .country(residencePayload.getCountry())
                .city(residencePayload.getCity())
                .area(residencePayload.getArea())
                .description(residencePayload.getDescription())
                .floorCount(residencePayload.getFloorCount())
                .services(residencePayload.getServices())
                .images(residencePayload.getImages())
                .build();


        residenceService.addResidence(residence);

        return ResponseEntity.accepted().build();
    }





}
