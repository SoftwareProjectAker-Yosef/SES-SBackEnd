package com.example.SES.services;
import com.example.SES.models.Residence;
import com.example.SES.repository.ResidenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepo residenceRepo;


    public List<Residence> getAllResidences(){
        return residenceRepo.findAll();
    }


    public void addResidence(Residence residence){
         residenceRepo.save(residence);
    }

    public Optional<Residence> tempGetResidence(Long id){
        return residenceRepo.findById(id);
    }




}
