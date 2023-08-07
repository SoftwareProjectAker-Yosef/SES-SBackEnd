package com.example.ses.repository;


import com.example.ses.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentRepo extends JpaRepository<Rent,Long> {

    Optional <List<Rent>> findByEmail(String email);
    List<Rent> findByNumber(String number);
    List<Rent> findByNumberAndDate(String number, String date);

    Optional <List<Rent>> findByOwnerEmail(String email);





}
