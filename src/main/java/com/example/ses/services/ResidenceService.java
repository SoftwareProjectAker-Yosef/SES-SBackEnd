package com.example.ses.services;
import com.example.ses.models.Residence;
import com.example.ses.repository.ResidenceRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepo residenceRepo;


    public Optional<List<Residence>> getAllResidences(int ans){
        return residenceRepo.findByAdminApproval(ans);
    }

    public void addResidence(Residence residence) {
        residenceRepo.save(residence);
    }

        public Optional<Residence> tempGetResidence (Long id){
            return residenceRepo.findById(id);
        }


        public Optional<List<Residence>> getOwnerResidences (String ownerEmail){

            return residenceRepo.findByOwnerEmailAndAdminApproval(ownerEmail, 1);


        }

    public Optional<List<Residence>> residencesForAdsAdmin (){

        return residenceRepo.findByAdNumberGreaterThan(4);


    }


    public Residence adminApproval(Long residenceId, int adminApproval) {
        Optional<Residence> residenceOptional = tempGetResidence(residenceId);

        if (residenceOptional.isPresent()) {
            Residence residence = residenceOptional.get();
            residence.setAdminApproval(adminApproval);
            return residenceRepo.save(residence);
        } else {
            // Handle the case where residenceId is not found
            throw new EntityNotFoundException("Residence not found with id: " + residenceId);
        }
    }



    public Residence adReq(Long residenceId) {
        Optional<Residence> residenceOptional = tempGetResidence(residenceId);

        if (residenceOptional.isPresent()) {
            Residence residence = residenceOptional.get();
            residence.setAdNumber(5);
            return residenceRepo.save(residence);
        } else {
            // Handle the case where residenceId is not found
            throw new EntityNotFoundException("Residence not found with id: " + residenceId);
        }
    }



    public Optional<List<Residence>> residencesForAdsUser (){
        return residenceRepo.findByAdNumberBetween(1,4);

    }


    public void acceptAd(Long residenceId){

        residenceRepo.decrementAdNumberForRange1To4();
        residenceRepo.decrementAdNumberById(residenceId);
    }




    public Residence resetAdReq(Long residenceId) {
        Optional<Residence> residenceOptional = tempGetResidence(residenceId);

        if (residenceOptional.isPresent()) {
            Residence residence = residenceOptional.get();
            residence.setAdNumber(0);
            return residenceRepo.save(residence);
        } else {
            // Handle the case where residenceId is not found
            throw new EntityNotFoundException("Residence not found with id: " + residenceId);
        }
    }


    }

