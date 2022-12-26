package com.turkcell.TechnicalService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//satılan ürünlerin tablosu
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private double price;
	
	@Column(length = 100)
	private String note;
	
	@ManyToOne(fetch = FetchType.EAGER)//bir ürün birden çok satışda bulunabilir
    @OnDelete(action = OnDeleteAction.CASCADE)//KURAL: Bir sale'de bir ürün satılabilir. Ama bir ürün birden fazla satışda var olablir.
	private Product product;
	
	private boolean ISSOLD;

}
