package com.turkcell.TechnicalService.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.model.Booking;
import com.turkcell.TechnicalService.repository.BookingRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
//@Transactional
public class BookingService {
	private BookingRepo repo;
	private EntityManager entityManager;
	
	/*public void refresh(Booking booking) {
		entityManager.refresh(booking);
	}
	
	public Booking createBooking(Booking booking) {	
		Booking temp=repo.save(booking);
		refresh(temp);
		return temp;
		
	}*/
	  
	public Booking createBooking(Booking booking) {
		//return repo.save(booking);
		LocalDate someDate=createBookingDate(booking.getSERVICE().getDURATION()); 
		booking.setBOOKINGDATE(someDate);
		booking=repo.saveAndFlush(booking);
		entityManager.clear();
		booking=repo.findById(booking.getID()).get();
		return booking;	
	}
	
	public Booking getByID(Long id) {
		//return repo.findById(id).get();//findById():optional döndürür. get() optional içindeki değeri almayı sağlar.
		return repo.findById(id).orElse(null);
		
	}

	public void deleteByID(Long id) {
		repo.deleteById(id);
		
	}


	public List<Booking> getAllByDateAsc()
	{
		return repo.OrderByBOOKINGDATEAsc();
	}

	public List<Booking> OrderByBOOKINGDATEDesc()
	{
		return repo.OrderByBOOKINGDATEDesc();

	}

	/*public List<Booking> findByBookingLikeName(String name)
	{
		return repo.findByBookingLikeName(name);

	}*/
	public List<Booking> findByUserName(String name)
	{
		return repo.findByUSERNAME(name);

	}
	public List<Booking> getAll()
	{
		return repo.findAll();
	}

	private LocalDate createBookingDate(int serviceDuration)
	{
		LocalDate bookingDate = LocalDate.now();
		int dailyWorkHours = 0;
		do
		{
			dailyWorkHours = serviceDuration;
			bookingDate = bookingDate.plusDays(1L);
			List<Booking> bookings = repo.searchByBOOKINGDATE(bookingDate);
			for (Booking booking : bookings)
			{
				dailyWorkHours += booking.getSERVICE().getDURATION();
			}
		}
		while (dailyWorkHours > 10);
		return bookingDate;
	}

	public Booking updateIsDone(Long id) {
		Booking booking=repo.findById(id).get();
		booking.setISDONE(true);
		return repo.save(booking);
	}

}
