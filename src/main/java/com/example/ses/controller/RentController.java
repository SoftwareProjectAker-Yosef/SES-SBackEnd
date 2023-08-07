package com.example.ses.controller;

import com.example.ses.models.Rent;

import com.example.ses.payload.RentPayload;

import com.example.ses.repository.RentRepo;

import com.example.ses.services.RentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rent")
@CrossOrigin(originPatterns = "*")
public class RentController {

    @Autowired
    private RentService rentservice;
    @Autowired
    private RentRepo rentrepo;

    @Autowired
    public RentController(RentService rentservice) {
        this.rentservice = rentservice;
    }

    @GetMapping("/getAllRent")
    public @ResponseBody ResponseEntity<List<Rent>> getAllRents() {
        return ResponseEntity.ok(rentservice.getAllRents());
    }

    @GetMapping("/getAllRentDates")
    public @ResponseBody ResponseEntity<List<String>> getAllRentDates() {
        return ResponseEntity.ok(rentservice.getAllRentDates());
    }

    @GetMapping("/dates")
    public @ResponseBody ResponseEntity<List<String>> getDatesByNumber(@RequestParam String number) {

        return ResponseEntity.ok(rentservice.getAllDatesByNumber(number));
    }


    @PostMapping( value="/saveRent",consumes = {"application/json"})
    public @ResponseBody ResponseEntity<?> addRentToDb(@RequestBody RentPayload rentPayload) {
        rentservice.addRent(
                Rent.builder()
                        .email(rentPayload.getEmail())
                        .ownerEmail(rentPayload.getOwnerEmail())
                        .date(rentPayload.getDate())
                        .number(rentPayload.getNumber())
                        .build()
        );

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/getTenantReservations")
    public @ResponseBody ResponseEntity<Optional<List<Rent>>> tenantReservations(@RequestParam String email) {
        return ResponseEntity.ok(rentservice.getRent(email));
    }


    @GetMapping("/getOwnerReservations")
    public @ResponseBody ResponseEntity<Optional<List<Rent>>> ownerReservations(@RequestParam String email) {
        return ResponseEntity.ok(rentservice.getOwnerRent(email));
    }

}
