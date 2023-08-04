package com.example.SES.services;


import com.example.SES.models.sellFurniture;
import com.example.SES.repository.sellFurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sellFurnitureService {




    @Autowired
    private sellFurnitureRepo furRepo;

    public List<sellFurniture> getAllFur() {

        return furRepo.findAll();

    }


    public sellFurniture getFur(String email)  {


        return furRepo.findByEmail(email).orElseGet(()->sellFurniture.builder().build());

    }
    public List<sellFurniture> getFurnitureByType(String type) {
        return furRepo.findByType(type);
    }

    public Optional<sellFurniture> tempGetFur(Long id) {
        return furRepo.findById(id);
    }
    public void addFur(sellFurniture Fur) {

        furRepo.save(Fur);
    }









}
