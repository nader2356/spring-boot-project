package com.school.pfe.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="classRoom")
public class ClassRoom extends AbstractEntity {
	private String classRoomNumber;

	private String bloc;
	
	/*@OneToMany (mappedBy="classRoom",fetch=FetchType.EAGER)
	private List<Seance> listSeance;*/
	
	@ManyToOne
	private School school ;
	
	
}

