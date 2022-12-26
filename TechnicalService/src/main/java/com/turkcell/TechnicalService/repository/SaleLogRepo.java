package com.turkcell.TechnicalService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.SaleLOG;

@Repository
public interface SaleLogRepo extends JpaRepository<SaleLOG, Long> {

}
