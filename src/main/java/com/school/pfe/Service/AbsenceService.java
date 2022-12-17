package com.school.pfe.Service;

import com.school.pfe.Dto.AbsenceDto;

import java.util.List;

public interface AbsenceService {

    AbsenceDto save(AbsenceDto dto);
    AbsenceDto findbyId(Long id);

    List<AbsenceDto> findAll();
    void delete(Long id);
}
