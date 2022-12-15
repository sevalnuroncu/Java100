package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.service.KonuService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="konu")
@AllArgsConstructor
public class KonuController {
	private KonuService konuService;
	
	@GetMapping(path="getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> getAll(){
		//localhost:8080/konu/getAll
		return konuService.getAll();
	}
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getByIdEntity(@PathVariable Long id)
	{
		// localhost:8080/konu/getById/1
		Konu konu = konuService.getByID(id);
		if (konu!= null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(konu);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		// localhost:8080/konu/deleteById/1
		if(konuService.deleteById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi");
		}
		
	}
	
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu)
	{
		// localhost:8080/konu/save
		
		konu = konuService.save(konu);
		return ResponseEntity.status(HttpStatus.CREATED).body(konu.toString() + " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/ogretmen/getById/" + konu.getID());
		
	}
	

}
