package com.example.SES.services;


import com.example.SES.models.sellFurniture;
import com.example.SES.repository.sellFurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public void addFur(sellFurniture Fur) {

        furRepo.save(Fur);
    }









}
