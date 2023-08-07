package com.example.SES.controller;

import com.example.SES.models.Rent;

import com.example.SES.payload.RentPayload;

import com.example.SES.repository.RentRepo;

import com.example.SES.services.RentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    public @ResponseBody ResponseEntity<?> getAllRents() {
        return ResponseEntity.ok(rentservice.getAllRents());
    }

    @GetMapping("/getAllRentDates")
    public @ResponseBody ResponseEntity<?> getAllRentDates() {
        return ResponseEntity.ok(rentservice.getAllRentDates());
    }

    @GetMapping("/dates")
    public @ResponseBody ResponseEntity<?> getDatesByNumber(@RequestParam String number) {

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
    public @ResponseBody ResponseEntity<?> tenantReservations(@RequestParam String email) {
        return ResponseEntity.ok(rentservice.getRent(email));
    }


    @GetMapping("/getOwnerReservations")
    public @ResponseBody ResponseEntity<?> ownerReservations(@RequestParam String email) {
        return ResponseEntity.ok(rentservice.getOwnerRent(email));
    }

}
