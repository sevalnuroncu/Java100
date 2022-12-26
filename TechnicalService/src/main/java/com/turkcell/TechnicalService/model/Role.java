package com.turkcell.TechnicalService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//kullanıcıların rolleri: kullanıcı -admin

@Entity
public class Role {
	
	private static final long serialVersionUID=3661468982812594323L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public String getAuthority() {
		return name;
	}
		
}
