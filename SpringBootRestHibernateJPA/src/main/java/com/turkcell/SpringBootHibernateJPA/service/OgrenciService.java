package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;
import com.turkcell.SpringBootHibernateJPA.repository.OgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgrenciService {
	private OgrenciRepository ogrenciRepository;

	public List<Ogrenci> getAll() {
	
		return ogrenciRepository.findAll();
	}

	public Ogrenci getByID(Long id) {
	
		return ogrenciRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		ogrenciRepository.deleteById(id);
		return ogrenciRepository.findById(id).isEmpty();
	}

	public Ogrenci save(Ogrenci ogrenci) {
		try
		{
			return ogrenciRepository.save(ogrenci);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}
