package com.school.pfe.Service;

import java.util.List;


import com.school.pfe.Dto.SalleDTO;

public interface SalleService {
	

	SalleDTO save(SalleDTO salleDTO);

	SalleDTO findById(Long id);

	    List<SalleDTO> findAll();

	    void delete(Long id);

}
