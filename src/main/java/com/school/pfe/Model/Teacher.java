package com.school.pfe.Model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="Teacher")
public class Teacher extends AbstractEntity{
	private String FirsName;
	private String LastName;
	private String Address;
	private String Email;
	private String Telephone;
	//@ManyToMany (mappedBy = "Teachers" ,fetch = FetchType.LAZY)
	//private Set<Planning> Plannings;
	
}
