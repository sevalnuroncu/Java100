package com.turkcell.SpringBootHibernateJPA.DTO;

import java.util.List;



import com.turkcell.SpringBootHibernateJPA.model.Ders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OgretmenDTO {
	private String NAME;
	private boolean ISGICIK;
	private List<Ders> dersler;
	
	//Dto yazarak veritabanı nesnesinin istediğmiz değişkenlerini kullanıcıdan saklayabiliriz.
	//Burada id'yi saklamış oluduk.
	
	//Ayrıca dto yazarak bir öğretmenin verdiği dersleride kullanıcıya gösterebildik.
	//dersler değişkenini öğretmen class'ı içinde yazdığımızda stackoverflow 
	//hatası alıyorduk. Dto yazarak bu hatadan da kurtulduk
	

}
