package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.DersOgrenci;
import com.turkcell.SpringBootHibernateJPA.repository.DersOgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersOgrenciService {
	private DersOgrenciRepository dersOgrenciRepository;

	public List<DersOgrenci> getAll() {
		
		return dersOgrenciRepository.findAll();
	}

	public DersOgrenci getByID(Long id) {
		
		return dersOgrenciRepository.findById(id).orElse(null);
	}

	public DersOgrenci save(DersOgrenci dersOgrenci) {
		try
		{
			return dersOgrenciRepository.save(dersOgrenci);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}

	public boolean deleteById(Long id) {
		dersOgrenciRepository.deleteById(id);
		return dersOgrenciRepository.findById(id).isEmpty();
	}

}
