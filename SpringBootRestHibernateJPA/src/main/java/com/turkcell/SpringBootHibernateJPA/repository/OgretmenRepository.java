package com.turkcell.SpringBootHibernateJPA.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;

public interface OgretmenRepository extends JpaRepository<Ogretmen, Long>{
										//tip olarak Ogretmen entitysinin primary key tipi yazılır
	
	//derived query
	public List<Ogretmen> findAllByNAMELike(String name, Sort sort);
	//interface'in içindeki methodlar override edilmek zorundadır.
	//Ama findAllByNAMELike methodu hiçbir yerde override edilmedi.
	//Spring framework bunu kendi kendine yapacak.
	//Kendi implemantasyonuna yapacak ve jpa repositoryde bulunmayan bir kod yazacak.
	//Bu methodlar sql query'lerine çevirilip hafızaya atılır.

	public List<Ogretmen> findAllByNAMELikeOrderByNAMEDesc(String name);

	public List<Ogretmen> findByNAMELike(String string);
	//↑Bu üç methodda aynı işlevi görür. 3 farklı şekilde yazabildik.
	
	
	//Yukarıdaki gibi yapmak istemezsek kendi sql'imizi yazıp yapabiliriz↓
	@Query(name="findByOgretmenName", value="SELECT * FROM obsh.ogretmen WHERE NAME LIKE %:NAME% order by NAME asc", nativeQuery = true )
	public List<Ogretmen> searchByName(@Param("NAME") String name);
}
