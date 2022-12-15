package com.turkcell.SpringBootHibernateJPA.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ders {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long ID;
	
	@ManyToOne(fetch = FetchType.EAGER)//Veritabanında ilişki türleri vardır. Örn: ManyToOne, OneToMany...
			//Bir öğretmenin birden fazla dersi olabilir. 1-->öğretmen n-->ders
			//ders classın'nın içinde olduğumuz için n-->ders=many , 1-->öğretmen=one 
			//Bu nedenle manytoone yazdık
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Ogretmen ogretmen;
	//private long OGR_ID;
	//JDBC de dersin içindeki öğretmeni almak için join'li sorgu yazmıştık. JPA de join işlemini de yapar. 
	//ORM-->objelerin ilişkilerini veritabanına maplemiş oluyor.
	//Bu nedenle Ders'in içine ogretmen objesini koyduk. 
	//Ders'in içinde öğretmenin ıd'sini tutmak yerine öğretmenin kendisini tuttuk.
	
	//private long KONU_ID;
	@ManyToOne(fetch = FetchType.EAGER) //Bir konu birden fazla ders
	@OnDelete(action = OnDeleteAction.CASCADE)//parent tabloda satırlar silindiğinde child tabloda da 
								//satırların silinmesini isteyip istemediğimizi belirtmek için kullanırız.
	private Konu konu;
	
	/*
	 *Stackoverflow sonsuz döngüye gider. DTO yazarak çözülebilir
	 * 
	 * @OneToMany(mappedBy = "ders", fetch = FetchType.LAZY )
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private List<DersOgrenci>
	 * dersOgrenciler;
	 */
	
	public Ders(Ogretmen ogretmen, Konu konu) {
		this.ogretmen = ogretmen;
		this.konu = konu;
	}
	
	

}
