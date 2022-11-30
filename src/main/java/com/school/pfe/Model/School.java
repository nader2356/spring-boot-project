package com.school.pfe.Model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="school")

public class School {
	@Id
    @GeneratedValue
    private Long idSchool ;
	@Column(name = "nom")
	private String nom;
	@Column(name = "adresse")
	private String adresse;
	
	@OneToMany(mappedBy="school")
	@JsonIgnore
    private List <Faculty> faculty;
	
	@OneToMany(mappedBy="school")
	@JsonIgnore
    private List <Salle> salles;
	

}
