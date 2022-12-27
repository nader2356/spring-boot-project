package com.school.pfe.Service;

import com.school.pfe.Dto.LabelValueDto;
import com.school.pfe.Dto.SectionDto;

import java.util.List;

public interface SectionService {

    SectionDto save(SectionDto sectionDto);

    SectionDto findById(Long id);

    SectionDto findByCode(String code);

    List<SectionDto> findAll();

    void delete(Long id);

    List<LabelValueDto> getSections();
}
