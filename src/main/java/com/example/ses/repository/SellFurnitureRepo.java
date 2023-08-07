package com.example.ses.repository;

import com.example.ses.models.SellFurniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellFurnitureRepo extends JpaRepository<SellFurniture,Long> {

    Optional<SellFurniture> findByEmail(String email);
    List<SellFurniture> findByType(String type);



}
