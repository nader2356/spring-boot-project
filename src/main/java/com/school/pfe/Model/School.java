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

public class School extends AbstractEntity {
	     
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy="school")
	@JsonIgnore
    private List <Faculty> faculties;
	@OneToMany(mappedBy="school")
	@JsonIgnore
    private List <Salle> salles;
	

}
