package com.school.pfe.Service;

import java.util.List;

import com.school.pfe.Dto.SchoolDto;

public interface SchoolService {
	  SchoolDto save(SchoolDto schoolDto);

	  SchoolDto findById(Long id);

	  SchoolDto findByName(String name);

	 List<SchoolDto> findAll();

	    void delete(Long id);


}
