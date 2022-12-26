package com.turkcell.TechnicalService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long>{

}
