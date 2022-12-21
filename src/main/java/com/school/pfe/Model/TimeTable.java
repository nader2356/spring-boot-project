package com.school.pfe.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTable extends AbstractEntity {

	@OneToOne
	private SchoolYear schoolYear;
	@OneToOne
	private Class classe;

	@OneToMany(mappedBy = "timeTable")
	List<Seance> Seances;
}