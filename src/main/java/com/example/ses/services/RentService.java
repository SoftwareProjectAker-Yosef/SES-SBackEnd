package com.example.ses.services;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.ses.models.Rent;

import com.example.ses.repository.RentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class RentService {


    @Autowired
    private RentRepo rentrepo;

    @Autowired
    public RentService(RentRepo rentrepo) {
        this.rentrepo = rentrepo;
    }
    public List<Rent> getAllRents() {

        return rentrepo.findAll();

    }


    public Optional<List<Rent>> getRent(String email)  {


        return rentrepo.findByEmail(email);

    }

    public Optional<List<Rent>> getOwnerRent(String email)  {


        return rentrepo.findByOwnerEmail(email);

    }

    public void addRent(Rent rent) {

        rentrepo.save(rent);
    }



    public List<String> getAllRentDates() {
        return rentrepo.findAll().stream().map(Rent::getDate).collect(Collectors.toList());
    }



    public List<String> getAllDatesByNumber(String number) {
        List<Rent> rents = rentrepo.findByNumber(number);
        return rents.stream().map(Rent::getDate).collect(Collectors.toList());
    }

    public boolean isRentDateAvailable(String number, String rentDate) {
        List<Rent> rents = rentrepo.findByNumberAndDate(number, rentDate);
        return rents.isEmpty();
    }


}
