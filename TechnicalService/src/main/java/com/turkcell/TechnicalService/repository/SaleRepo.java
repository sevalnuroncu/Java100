package com.turkcell.TechnicalService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Sale;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long>{

	public List<Sale> findAllByISSOLD(boolean ISSOLD);

	public List<Sale> findAllByproductIDAndISSOLD(Long id, boolean b);

}
