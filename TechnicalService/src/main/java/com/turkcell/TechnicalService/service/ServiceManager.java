package com.turkcell.TechnicalService.service;

import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.repository.ServiceRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceManager {
	private ServiceRepo repo;
	
	public com.turkcell.TechnicalService.model.Service findById(Long id)
	{
		return repo.findById(id).get();
	}

}
