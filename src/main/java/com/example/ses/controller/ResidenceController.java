package com.example.ses.controller;

import com.example.ses.models.Residence;
import com.example.ses.payload.ResidencePayload;

import com.example.ses.services.ResidenceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/residence")
@CrossOrigin(originPatterns = "*")
public class ResidenceController {

@Autowired
    private ResidenceService residenceService;


    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<Optional<List<Residence>>> getAllResidences() {
        return ResponseEntity.ok(residenceService.getAllResidences(1));
    }

    @GetMapping("/getAllUnAccepted")
    public @ResponseBody ResponseEntity<Optional<List<Residence>>> getAllUnAcceptedResidences() {
        return ResponseEntity.ok(residenceService.getAllResidences(0));
    }



    @GetMapping("/test")
    public @ResponseBody ResponseEntity<Optional<Residence>> testGetResidence(@RequestParam Long id) {
        return ResponseEntity.ok(residenceService.tempGetResidence(id));
    }




    @GetMapping("/getOwnerHouses")
    public @ResponseBody ResponseEntity<Optional<List<Residence>>> getOwnerResidences(@RequestParam String ownerEmail) {
        return ResponseEntity.ok(residenceService.getOwnerResidences(ownerEmail));
    }




    @PostMapping( value="/saveResidence",consumes = {"application/json"})
    public ResponseEntity<Void> addResidenceToDb(@RequestBody ResidencePayload residencePayload) {
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



    @GetMapping("/getResidencesForAdsAdmin")
    public @ResponseBody ResponseEntity<Optional<List<Residence>>> residencesAdsAdmin() {
        return ResponseEntity.ok(residenceService.residencesForAdsAdmin());
    }


    @GetMapping("/getResidencesForAdsUser")
    public @ResponseBody ResponseEntity<Optional<List<Residence>>>  residencesAdsUser() {
        return ResponseEntity.ok(residenceService.residencesForAdsUser());
    }


@Transactional
    @PutMapping("/requestAd")
    public ResponseEntity<Residence> updateRequestAd(@RequestParam Long id) {
        try {
            Residence updatedResidence = residenceService.adReq(id);
            return ResponseEntity.ok(updatedResidence);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PutMapping("/acceptAd")
    public ResponseEntity<String> acceptAd(@RequestParam Long id) {
        try {
            residenceService.acceptAd(id);
            return ResponseEntity.ok("Ad accepted and adNumber decremented successfully.");
        } catch (Exception e) {
            String errorMessage = "An error occurred while accepting the ad: " + e.getMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
    }


    @Transactional
    @PutMapping("/declineAd")
    public ResponseEntity<String> declineAd(@RequestParam Long id) {
        try {
            residenceService.resetAdReq(id);
            return ResponseEntity.ok("Ad declined and adNumber decremented successfully.");
        } catch (Exception e) {
            String errorMessage = "An error occurred while accepting the ad: " + e.getMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
    }

}
