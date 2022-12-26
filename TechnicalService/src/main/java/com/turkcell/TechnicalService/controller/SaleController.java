package com.turkcell.TechnicalService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.service.SaleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "sale")
@AllArgsConstructor
public class SaleController
{

	private SaleService saleService;
	
	@PostMapping("save")
	public Sale createSale(@RequestBody Sale sale)
	{   //localhost:8080/sale/save
		//{"price":"100","note":"deneme not","product":{"id":1}}
		return saleService.createSale(sale);
	}

	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id)
	{	//localhost:8080/sale//deleteById/1
		saleService.deleteById(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}


	@GetMapping("getAll")
	public List<Sale> getAllSale()
	{	//localhost:8080/sale/getAll
		return saleService.getAllSale();
	}
	
	@GetMapping("getByProduct/{id}")
	public List<Sale> getByProduct(@PathVariable(name = "id") Long id)
		//Satılan ürünlerde parça ile arama yapılabilmelidir 
		//Buradaki id product'ın id'sidir. Sale'in id'si değildir.
	{	//localhost:8080/sale/getByProduct/1
		return saleService.getByProduct(id);
	}
}