package com.turkcell.SpringBootHibernateJPA.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "NOTE<101")//Not 100'den büyük olamaz kuralı buraya yazılmalıdır.
public class DersOgrenci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@ManyToOne //Bir öğrencinin birden fazla ders kaydı var
	@JoinColumn(foreignKey =@ForeignKey(name = "OGRENCI_FK"))
	//foreign key'e isim vermek için kullanıldı.
	//Bu column başka bir tablodan join ediliyor demektir
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ogrenci ogrenci; 
	
	@ManyToOne //Bir dersin birden fazla ders öğrenci kaydı var
	@JoinColumn(foreignKey =@ForeignKey(name = "DERS_FK"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ders ders;
	
	private int DEVAMSIZLIK;
	 
	private long NOTE;

	public DersOgrenci(Ogrenci ogrenci, Ders ders, int dEVAMSIZLIK, long nOTE) {
		this.ogrenci = ogrenci;
		this.ders = ders;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}
	
	
	
}
