package com.school.pfe.Model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="Professeur")
public class Professeur {
	@Id
    @GeneratedValue
    private Long idProf ;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Email;
	private String Telephone;
	@ManyToMany (mappedBy = "Professeurs" ,fetch = FetchType.LAZY)
	private Set<Planning> Plannings;
	
}
