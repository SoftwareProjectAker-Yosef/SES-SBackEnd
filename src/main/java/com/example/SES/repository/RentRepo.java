package com.example.SES.repository;


import com.example.SES.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepo extends JpaRepository<Rent,Long> {

    Optional<Rent> findByEmail(String email);



}
