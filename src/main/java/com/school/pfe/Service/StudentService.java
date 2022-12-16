package com.school.pfe.Service;

import com.school.pfe.Dto.AbsenceDto;
import com.school.pfe.Dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto dto);
    StudentDto findbyId(Long id);

    List<StudentDto> findAll();
    void delete(Long id);
}
