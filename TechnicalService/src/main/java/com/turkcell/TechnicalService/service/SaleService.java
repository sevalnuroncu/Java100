package com.turkcell.TechnicalService.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.repository.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

	private SaleRepo saleRepo;
	private EntityManager em;
	
	
	public Sale createSale(Sale sale) {
		sale=saleRepo.saveAndFlush(sale);
		em.clear();
		sale=saleRepo.findById(sale.getId()).get();
		return sale;	
	}
	
	public List<Sale> getAllSale(){
		
		return saleRepo.findAllByISSOLD(false);
	}

	public void deleteById(Long id)
	{
		saleRepo.deleteById(id);
	}

	public List<Sale> getByProduct(Long id)
	{
		return saleRepo.findAllByproductIDAndISSOLD(id, false);
	}
}
