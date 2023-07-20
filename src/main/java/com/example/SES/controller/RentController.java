package com.example.SES.controller;

import com.example.SES.models.Rent;
import com.example.SES.models.User;
import com.example.SES.payload.RentPayload;
import com.example.SES.payload.UserPayload;
import com.example.SES.repository.RentRepo;
import com.example.SES.repository.UserRepo;
import com.example.SES.services.RentService;
import com.example.SES.services.UserService;
import jakarta.validation.Payload;
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

    @GetMapping("/getRent")
    public @ResponseBody ResponseEntity<?> getAllRents() {
        return ResponseEntity.ok(rentservice.getAllRents());
    }

    @GetMapping("/getAllRentDates")
    public @ResponseBody ResponseEntity<?> getAllRentDates() {
        return ResponseEntity.ok(rentservice.getAllRentDates());
    }

    @GetMapping("/getRentDate")
    public @ResponseBody ResponseEntity<?> testGetResidence(@RequestParam Long id) {
        return ResponseEntity.ok(rentservice.getRentDateById(id));
    }


    @PostMapping( value="/saveRent",consumes = {"application/json"})
    public @ResponseBody ResponseEntity<?> addRentToDb(@RequestBody RentPayload rentPayload) {
        rentservice.addRent(
                Rent.builder()
                        .email(rentPayload.getEmail())
                        .ownerEmail(rentPayload.getOwnerEmail())
                        .date(rentPayload.getDate())
                        .number(rentPayload.getNumber())
                        .noMonth(rentPayload.getNoMonth())
                        .build()
        );

        return ResponseEntity.accepted().build();
    }



}
