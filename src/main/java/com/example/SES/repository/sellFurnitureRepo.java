package com.example.SES.repository;

import com.example.SES.models.sellFurniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface sellFurnitureRepo extends JpaRepository<sellFurniture,Long> {

    Optional<sellFurniture> findByEmail(String email);



}
