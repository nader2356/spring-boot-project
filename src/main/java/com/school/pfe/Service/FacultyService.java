package com.school.pfe.Service;

import com.school.pfe.Dto.FacultyDto;

import java.util.List;

public interface FacultyService {

    FacultyDto save(FacultyDto facultyDto);

    FacultyDto findById(Integer id);

    List<FacultyDto> findAll();

    void delete(Integer id);
}
