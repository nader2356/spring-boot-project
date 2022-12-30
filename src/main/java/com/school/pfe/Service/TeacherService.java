package com.school.pfe.Service;

import java.util.List;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Dto.TeacherValueDto;

public interface TeacherService {
    TeacherDto save(TeacherDto teacherDto);

    TeacherDto findById(Long id);

    TeacherValueDto teacherById(Long id);

    List<TeacherDto> findAll();

    void delete(Long id);
}
