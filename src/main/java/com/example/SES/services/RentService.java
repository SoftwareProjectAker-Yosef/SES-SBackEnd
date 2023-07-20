package com.example.SES.services;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.SES.models.Rent;
import com.example.SES.models.Residence;
import com.example.SES.models.User;
import com.example.SES.repository.RentRepo;
import com.example.SES.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class RentService {


    @Autowired
    private RentRepo rentrepo;

    public List<Rent> getAllRents() {

        return rentrepo.findAll();

    }


    public Rent getRent(String email)  {


        return rentrepo.findByEmail(email).orElseGet(()->Rent.builder().build());

    }

    public void addRent(Rent rent) {

        rentrepo.save(rent);
    }



    public List<String> getAllRentDates() {
        return rentrepo.findAll().stream().map(Rent::getDate).collect(Collectors.toList());
    }


    public String getRentDateById(Long id) {
        return rentrepo.findById(id)
                .map(Rent::getDate)
                .orElseThrow(() -> new RuntimeException("Rent not found with id " + id));
    }







}
