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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ogrenci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	private String NAME;
	
	@Column(unique = true)//öğrenci numaraları benzersiz olsun. tekrar etmesin
	private long OGRNUMBER;
	
	private long YEAR;
	
	/*//stackoverflow
	 * 
	 * @OneToMany(mappedBy = "ogrenci", fetch = FetchType.LAZY)
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private List<DersOgrenci>
	 * dersOgrenciler;
	 */
	
	public Ogrenci(String nAME, long oGRNUMBER, long yEAR) {
		
		NAME = nAME;
		OGRNUMBER = oGRNUMBER;
		YEAR = yEAR;
	}

}
