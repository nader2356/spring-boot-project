package com.school.pfe.Model;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="salle")
public class Salle  {
	@Id
	@GeneratedValue
	private Long idSalle;
	@Column(name = "numSalle")
	private String numSalle;
	@Column(name = "numBloc")
	private String bloc;
	@ManyToMany(mappedBy ="salles",fetch = FetchType.LAZY)
	private Set<Planning> plannings;
	@ManyToOne
	@JoinColumn(name = "ecole_Id")
	@JsonIgnore
	private Ecole ecole;
/*	*/
}
