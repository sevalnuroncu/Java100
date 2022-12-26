package com.turkcell.TechnicalService.model;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//randevu
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	//@Temporal(TemporalType.DATE)//otomatik olarak tarih verir
	private LocalDate BOOKINGDATE;
	
	@Column(length = 300)//eklenen not en fazla 300 karakter olsun
	private String NOTE;
	
	@ManyToOne(fetch = FetchType.EAGER)//Bir user birden fazla randevu oluşturabilir
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SystemUser USER;
	
	@ManyToOne(fetch = FetchType.EAGER)//Bir servis(örn:formatlama) birden fazla randevuda var olabilir.
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Service SERVICE;//KURAL: Bir kullanıcı bir randevuda  bir tane hizmet alabilir.
	
	private boolean ISDONE;
	

}
