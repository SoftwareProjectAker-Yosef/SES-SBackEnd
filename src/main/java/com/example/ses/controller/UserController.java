package com.example.ses.controller;

import com.example.ses.models.User;
import com.example.ses.payload.UserPayload;
import com.example.ses.repository.UserRepo;
import com.example.ses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getUser")
    public @ResponseBody ResponseEntity<User> getByEmail( @RequestParam String email) {
        return ResponseEntity.ok(userService.getUser(email));
    }



    @GetMapping("/checkUserExistence")
    public @ResponseBody ResponseEntity<Boolean> userExists(@RequestParam String email) {
        return ResponseEntity.ok(userService.userExists(email));
    }

    @PostMapping("/checkPassword")
    public @ResponseBody ResponseEntity<Boolean> checkPassword(@RequestParam String email, String password) {
        return ResponseEntity.ok(userService.getUser(email).getPassword().equals(password));
    }

    @PostMapping( value="/saveUser",consumes = {"application/json"})
    public @ResponseBody ResponseEntity<Void> addUserToDb(@RequestBody UserPayload userPayload) {
        userService.addUser(
                User.builder()
                        .email(userPayload.getEmail())
                        .password(userPayload.getPassword())
                        .firstName(userPayload.getFirstName())
                        .lastName(userPayload.getLastName())
                        .phoneNumber(userPayload.getPhoneNumber())
                        .alternatePhoneNumber(userPayload.getAlternatePhoneNumber())
                        .universityMajor(userPayload.getUniversityMajor())
                        .workPlace(userPayload.getWorkPlace())
                        .age(userPayload.getAge())
                        .userType(userPayload.getUserType())
                        .build()
        );

        return ResponseEntity.accepted().build();
    }



}
