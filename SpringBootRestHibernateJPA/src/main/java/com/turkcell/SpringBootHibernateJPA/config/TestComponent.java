package com.turkcell.SpringBootHibernateJPA.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repository.DersRepository;
import com.turkcell.SpringBootHibernateJPA.repository.KonuRepository;
import com.turkcell.SpringBootHibernateJPA.repository.OgretmenRepository;

import lombok.AllArgsConstructor;

//test datasını veritabanına insert etmek bu classı oluşturduk. data.sql dosyası oluşturup ordan sql kodu yazarak da yapabilirdik.
//Uygulama ayağa kalkarken
//@Component//Bean olarak hafızaya atılması için ayağa kalkmasını sağlar. Bir kere çalıştırıldı. Bir daha ayağa kalmaması için comment yapıldı.
@AllArgsConstructor
public class TestComponent {//TestService gibi düşünebiliriz.
	
	private OgretmenRepository ogretmenRepo;

	/*
	 * private KonuRepository konuRepository;
	 * 
	 * private DersRepository dersRepository;
	 */
	@PostConstruct//Bean'i hafızaya at ve test methodundaki işi gerçekleştir.
	public void test() {
		Ogretmen ogretmen=new Ogretmen("numan", false);
		ogretmenRepo.save(ogretmen);
		Ogretmen ogretmen2=new Ogretmen("tuba", true);
		ogretmenRepo.save(ogretmen2);
		
//		Konu konu = new Konu("Java");
//		konuRepo.save(konu);
//		
//		Konu konu2 = new Konu("C++");
//		konuRepo.save(konu2);
//		
//		Konu konu3 = new Konu("C#");
//		konuRepo.save(konu3);
//		
//		Ders ders = new Ders(ogretmen,konu);
//		dersRepo.save(ders);
//		
//		Ders ders2 = new Ders(ogretmen,konu3);
//		dersRepo.save(ders2);
//		
//		Ders ders3 = new Ders(ogretmen2,konu);
//		dersRepo.save(ders3);
//		
//		Ders ders4 = new Ders(ogretmen2,konu2);
//		dersRepo.save(ders4);
		
	}

}
