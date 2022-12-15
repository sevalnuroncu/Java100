package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.repository.KonuRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class KonuService {
	private KonuRepository konuRepository;
	
	public List<Konu> getAll() {
		return konuRepository.findAll();
	}

	public Konu getByID(Long id) {
		
		return konuRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		konuRepository.deleteById(id);
		return konuRepository.findById(id).isEmpty();
	}

	public Konu save(Konu konu) {
		try
		{
			return konuRepository.save(konu);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}

}
