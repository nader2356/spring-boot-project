package com.school.pfe.Model;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="salle")
public class Salle extends AbstractEntity {
	
	@Column(name = "salleNumber")
	private String salleNumber;
	@Column(name = "blocNumber")
	private String bloc;
	//@ManyToMany(mappedBy ="salles",fetch = FetchType.LAZY)
	//private List<Planning> plannings;
	
	@ManyToOne
	@JoinColumn(name = "school_Id")
	private School school ;
/*	*/
}
