package com.example.ms1.repository;

import com.example.ms1.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimOffersRepository extends JpaRepository<SimOffers,Integer> {
    public SimOffers findBySimId(int id);
}
