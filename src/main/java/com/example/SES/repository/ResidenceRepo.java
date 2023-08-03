package com.example.SES.repository;

import com.example.SES.models.Residence;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ResidenceRepo extends JpaRepository<Residence,Long> {
    Optional<List<Residence>> findByOwnerEmailAndAdminApproval(String email, int ans);

    Optional<List<Residence>> findByAdminApproval(int ans);






}
