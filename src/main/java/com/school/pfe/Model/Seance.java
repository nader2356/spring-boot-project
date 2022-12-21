package com.school.pfe.Model;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Seance extends AbstractEntity{

	private String day;
	private String numSeance;



	private int coursID;
	@ManyToOne
	private ClassRoom ClassRoom;
	@ManyToOne
	private Teacher teacher;

	@OneToMany
	Set<Absence> Absences;

	@ManyToOne
	private TimeTable timeTable;}
