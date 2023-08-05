package com.example.SES.repository;

import com.example.SES.models.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;
import java.util.Optional;

public interface ResidenceRepo extends JpaRepository<Residence,Long> {
    Optional<List<Residence>> findByOwnerEmailAndAdminApproval(String email, int ans);

    Optional<List<Residence>> findByAdminApproval(int ans);

    Optional<List<Residence>> findByAdNumberGreaterThan(int value);
    Optional<List<Residence>> findByAdNumberBetween(int min, int max);

    @Modifying
    @Query("UPDATE Residence r SET r.adNumber = r.adNumber - 1 WHERE r.id = :residenceId")
    void decrementAdNumberById(@Param("residenceId") Long residenceId);


    @Modifying
    @Query("UPDATE Residence r SET r.adNumber = r.adNumber - 1 WHERE r.adNumber BETWEEN 1 AND 4")
    void decrementAdNumberForRange1To4();












}
