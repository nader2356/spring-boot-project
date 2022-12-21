package com.school.pfe.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTable extends AbstractEntity {

	@OneToOne
	private AcademicYear AcademicYear;
	@OneToOne
	private Class Classe;
	@OneToMany
	Set<Seance> Seances;
}