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
import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;
import com.turkcell.SpringBootHibernateJPA.service.OgrenciService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="ogrenci")
@AllArgsConstructor
public class OgrenciController {
	private OgrenciService ogrenciService;
	
	@GetMapping(path="getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ogrenci> getAll(){
		//localhost:8080/ogrenci/getAll
		return ogrenciService.getAll();
	}
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByIdEntity(@PathVariable Long id)
	{
		// localhost:8080/ogrenci/getById/1
		Ogrenci ogrenci = ogrenciService.getByID(id);
		if (ogrenci!= null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(ogrenci);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		// localhost:8080/ogrenci/deleteById/1
		if(ogrenciService.deleteById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi");
		}
		
	}
	
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogrenci ogrenci)
	{
		// localhost:8080/ogrenci/save
		
		ogrenci = ogrenciService.save(ogrenci);
		return ResponseEntity.status(HttpStatus.CREATED).body(ogrenci.toString() + " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/ogretmen/getById/" + ogrenci.getID());
		
	}
	
}
