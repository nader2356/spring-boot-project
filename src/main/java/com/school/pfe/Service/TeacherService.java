package com.school.pfe.Service;

import java.util.List;

import com.school.pfe.Dto.TeacherDto;

public interface TeacherService {
    TeacherDto save(TeacherDto teacherDto);

    TeacherDto teacherById(Long id);

    List<TeacherDto> findAll();

    void delete(Long id);
}
