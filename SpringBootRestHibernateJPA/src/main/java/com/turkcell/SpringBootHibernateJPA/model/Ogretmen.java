package com.turkcell.SpringBootHibernateJPA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //Veritabanında tabloların oluşmasını sağlayan annotation
//@javax.persistance.Entity şeklinde de yazılabilir. Hangi paketten geldiğini belirtmek için.
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ogretmen {
	
	@Id //ID'nin veritabanı tablosunda primary key'e karşılık geldiğini anlatır
	@GeneratedValue(strategy=GenerationType.IDENTITY)//id'lerin unique olmasını ve birer birer artmasını sağlar
	//Identity column'u yani bir sequences oluştur ve buraya bağla demektir. sequences'den tek tek numara ver.
	private long ID;
	@Column(length=100)//isim maksimum 100 karakter olabilir
	private String NAME;
	private boolean ISGICIK; 
	
	/*@JsonBackReference
	@OneToMany(mappedBy = "ogretmen", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Ders> dersler;*/
	
	public Ogretmen(String nAME, boolean iSGICIK) {
		
		NAME = nAME;
		ISGICIK = iSGICIK;
	}
	
	

	

	

}
