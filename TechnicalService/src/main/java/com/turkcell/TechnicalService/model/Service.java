package com.turkcell.TechnicalService.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//yapılan işlemler(formatlama, virüs temizliği, diskten veri kurtarma, fan ve termal macun temizliği) bu tabloda

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String NAME;//hizmet ismi:formatlama, virüs temizleme, disk kurtarma, fan temizliği
	
	private int DURATION;//hizmet süresi
	
	private int DESKTOP;
	private int LAPTOP;
	private int MAC;
	
}
