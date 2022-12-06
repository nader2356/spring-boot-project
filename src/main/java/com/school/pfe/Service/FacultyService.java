package com.school.pfe.Service;

import com.school.pfe.Dto.FacultyDto;

import java.util.List;

public interface FacultyService {

    FacultyDto save(FacultyDto facultyDto);

    FacultyDto findById(Long id);

    FacultyDto findByCode(String code);

    List<FacultyDto> findAll();

    void delete(Long id);
}
