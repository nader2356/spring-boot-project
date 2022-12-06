package com.school.pfe.Service;

import com.school.pfe.Dto.SchoolYearDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolYearService {
    ResponseEntity<List<SchoolYearDto>> findAll();

    ResponseEntity<SchoolYearDto> findById(Long id);

    ResponseEntity<SchoolYearDto> save(SchoolYearDto Dto);

    ResponseEntity<Void> deleteById(Long id) ;

    ResponseEntity<SchoolYearDto> findSchoolYearByYear(String year);

}
