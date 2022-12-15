package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.DTO.OgretmenDTO;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repository.OgretmenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgretmenService {
	
	private OgretmenRepository ogretmenRepo;
	
	public List<Ogretmen> getAll(){
		return ogretmenRepo.findAll();//findAll(): jpa repository methodudur.
 	}
	public Ogretmen getByID(long id) {
		//return ogretmenRepo.findById(id).get(); 
		//findById optional döndürdüğü için devamında isEmpty, isPresent gibi bir şeyler yazmak gerekir.
		//id varsa return et anlamında bu işlem yapılır
		//Biz get kullandık çünkü getin içinde null gelirse otomatik exception fırlatması için gerekli kod var
		return ogretmenRepo.findById(id).orElse(null); 
		//hata vermemesi için null verdik
	}
	
	
	
	public Ogretmen save(Ogretmen ogretmen)
	{
		try
		{
			return ogretmenRepo.save(ogretmen);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public boolean deleteById(Long id) {
		
		ogretmenRepo.deleteById(id);
		return ogretmenRepo.findById(id).isEmpty();
	
		
	}
	public List<Ogretmen> findNameLike(String expression) {
		//select * from obsh.ogretmen where name like '%an%'
		//return ogretmenRepo.findAllByNAMELike("%"+expression+"%",Sort.by(Order.desc("ID")));
		//findAllByNAMELike:bu isimlendirme şeklinin bir standardı vardır
		//return ogretmenRepo.findAllByNAMELikeOrderByNAMEDesc("%"+expression+"%");//-->isime göre descending sırala
		//return ogretmenRepo.findByNAMELike("%"+expression+"%");
		return ogretmenRepo.searchByName(expression); 
	}

}
