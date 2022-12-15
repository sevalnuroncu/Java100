package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.DTO.OgretmenDTO;
import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repository.DersRepository;
import com.turkcell.SpringBootHibernateJPA.repository.OgretmenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgretmenDTOService {
	private OgretmenRepository ogretmenRepo;
	private DersRepository dersRepo;
	public OgretmenDTO getByID(long id) {
		Ogretmen ogretmen = ogretmenRepo.findById(id).get();
		List<Ders> dersler=dersRepo.findAllByogretmen_ID(id);
		OgretmenDTO ogretmenDTO=new OgretmenDTO(ogretmen.getNAME(), ogretmen.isISGICIK(), dersler);
		return ogretmenDTO;
	}

}
