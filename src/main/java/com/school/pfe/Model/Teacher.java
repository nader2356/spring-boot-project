package com.school.pfe.Model;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Table(name="Teacher")
public class Teacher extends AbstractEntity{
	private String firsName;
	private String lastName;
	@Embedded
	private Address address;
	private String email;
	private String telephone;
	private String image;
	@OneToMany (mappedBy = "teacher" )
	private List<Seance> seances;
	@ManyToOne
	private Subject subject;
}
