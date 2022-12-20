package com.school.pfe.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Timetable {
	@Id
    @GeneratedValue
	long idPlanning;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="timetable")
	List<Seance> timetablePlanning;
	
	@OneToOne
	Class classTeam;
	
}
