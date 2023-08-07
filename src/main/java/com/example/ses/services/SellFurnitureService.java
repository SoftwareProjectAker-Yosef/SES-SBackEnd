package com.example.ses.services;


import com.example.ses.models.SellFurniture;

import com.example.ses.repository.SellFurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellFurnitureService {




    @Autowired
    private SellFurnitureRepo furRepo;

    public List<SellFurniture> getAllFur() {

        return furRepo.findAll();

    }


    public SellFurniture getFur(String email)  {


        return furRepo.findByEmail(email).orElseGet(()->SellFurniture.builder().build());

    }
    public List<SellFurniture> getFurnitureByType(String type) {
        return furRepo.findByType(type);
    }

    public Optional<SellFurniture> tempGetFur(Long id) {
        return furRepo.findById(id);
    }
    public void addFur(SellFurniture fur) {

        furRepo.save(fur);
    }









}
