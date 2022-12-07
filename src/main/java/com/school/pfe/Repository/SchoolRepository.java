package com.school.pfe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.School;

@Repository
public interface SchoolRepository  extends JpaRepository<School, Long>{
	 Optional<School> findSchoolByName(String name);	

}
