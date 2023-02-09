package com.example.ms2.repository;

import com.example.ms2.entity.SimDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails,Integer> {
    public SimDetails findByServiceNumberAndSimNumber(String serviceNumber, String simNumber);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE SimDetails s SET s.simStatus = :status WHERE s.simId = :id")
    public int activateSim(@Param("status") String status,@Param("id") int id);

}
