package com.example.SES.controller;

import com.example.SES.models.Residence;
import com.example.SES.repository.ResidenceRepo;
import com.example.SES.payload.ResidencePayload;

import com.example.SES.services.ResidenceService;
import jakarta.persistence.EntityNotFoundException;
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
        return ResponseEntity.ok(residenceService.getAllResidences(1));
    }

    @GetMapping("/getAllUnAccepted")
    public @ResponseBody ResponseEntity<?> getAllUnAcceptedResidences() {
        return ResponseEntity.ok(residenceService.getAllResidences(0));
    }



    @GetMapping("/test")
    public @ResponseBody ResponseEntity<?> testGetResidence(@RequestParam Long id) {
        return ResponseEntity.ok(residenceService.tempGetResidence(id));
    }


    @GetMapping("/getResidencesForAds")
    public @ResponseBody ResponseEntity<?> residencesAds() {
        return ResponseEntity.ok(residenceService.residencesForAds());
    }

    @GetMapping("/getOwnerHouses")
    public @ResponseBody ResponseEntity<?> getOwnerResidences(@RequestParam String ownerEmail) {
        return ResponseEntity.ok(residenceService.getOwnerResidences(ownerEmail));
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
                .adminApproval(residencePayload.getAdminApproval())
                .description(residencePayload.getDescription())
                .floorCount(residencePayload.getFloorCount())
                .bedrooms(residencePayload.getBedrooms())
                .bathrooms(residencePayload.getBathrooms())
                .services(residencePayload.getServices())
                .images(residencePayload.getImages())
                .build();


        residenceService.addResidence(residence);

        return ResponseEntity.accepted().build();
    }


    @PutMapping("/admin-approval")
    public ResponseEntity<Residence> updateAdminApproval(@RequestParam Long id, @RequestParam int adminApproval) {
        try {
            Residence updatedResidence = residenceService.adminApproval(id, adminApproval);
            return ResponseEntity.ok(updatedResidence);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }




}
