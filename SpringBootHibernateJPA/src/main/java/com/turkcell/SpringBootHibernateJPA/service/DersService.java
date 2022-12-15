package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.repository.DersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersService {
	private DersRepository dersRepository;
	
	public List<Ders> getAll() {
		
		return dersRepository.findAll();
	}

	public Ders save(Ders ders) {
		try
		{
			return dersRepository.save(ders);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Ders getByID(Long id) {
		
		return dersRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		
		dersRepository.deleteById(id);
		return dersRepository.findById(id).isEmpty();
	}

}
