package com.school.pfe.Service;

import com.school.pfe.Dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto save(SubjectDto subjectDto);

    SubjectDto findById(Long id);

    SubjectDto findByName(String name);

    List<SubjectDto> findAll();

    void delete(Long id);
}
