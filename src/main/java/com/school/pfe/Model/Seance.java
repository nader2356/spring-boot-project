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
	private int numSeance;
	private int coursID;
	@ManyToOne
	private ClassRoom classRoom;
	@ManyToOne
	private Teacher teacher;

	@OneToMany(mappedBy = "seance")
	Set<Absence> absences;

	@ManyToOne
	private TimeTable timeTable;}
