package com.turkcell.TechnicalService.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.model.Booking;
import com.turkcell.TechnicalService.service.BookingService;
import com.turkcell.TechnicalService.service.ServiceManager;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/booking")
@AllArgsConstructor
public class BookingController {
	private BookingService service;
	private ServiceManager serviceManager;
	
	@PostMapping(path="save")
	public Booking save(@RequestBody Booking booking) {
		//localhost:8080/booking/save
		//{"note":"noteeee","user":{"id":1},"service":{"id":1}}
		booking.setSERVICE(serviceManager.findById(booking.getSERVICE().getID()));
		return service.createBooking(booking);
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id)
	{	//localhost:8080/booking/deleteById/6
		service.deleteByID(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}
	
	
	@PutMapping("update/{id}")
	public Booking update(@PathVariable(name= "id") Long id)  {
		//randevu id ‘si verilerek randevu işlemi tamamlandı olarak güncellenir.
		//localhost:8080/booking/update/1
		return service.updateIsDone(id);
	}
	

	@GetMapping(path = "getById/{id}")
	public Booking getById(@PathVariable(name = "id") Long id)
	{	//localhost:8080/booking/getById/2
		return service.getByID(id);
	}
	
	@GetMapping("getAll")
	public List<Booking> getAll(){
		//localhost:8080/booking/getAll
		return service.getAll();
	}
	
	@GetMapping(path="getAllByDateAsc")
	public List<Booking> getAllByDateAsc(){
		//localhost:8080/booking/getAllByDateAsc
		return service.getAllByDateAsc();
	}
	
	@GetMapping(path="getAllByDateDesc")
	public List<Booking> OrderByBOOKINGDATEDesc(){
		//localhost:8080/booking/getAllByDateDesc
		return service.OrderByBOOKINGDATEDesc();
	}
	
	@GetMapping(path="findByBookingLikeName")
	public List<Booking> findByBookingLikeName(@RequestParam(name="name") String name) {
		//Randevularda kayıtlı kullanıcının ismi ile arama yapılır (like sorgusu ile)
		//localhost:8080/booking/findByBookingLikeName?name=admin
		return service.findByUserName(name);
	}
	
	
	
}
