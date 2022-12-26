package com.turkcell.TechnicalService.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.model.SaleLOG;
import com.turkcell.TechnicalService.repository.SaleLogRepo;
import com.turkcell.TechnicalService.repository.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleLogService {
	private SaleLogRepo repo;
	private SaleRepo saleRepo;
	private EntityManager em;
	
	public SaleLOG create(SaleLOG log) {
		log=repo.save(log);
		repo.flush();
		em.clear();
		log=repo.findById(log.getID()).get();
		log.getSALE().setISSOLD(true);
		saleRepo.save(log.getSALE());
		return log;  
	}
 }
