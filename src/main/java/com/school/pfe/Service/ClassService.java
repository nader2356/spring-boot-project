package com.school.pfe.Service;

import com.school.pfe.Dto.ClassDto;
import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.SchoolYearDto;
import com.school.pfe.Model.Class;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassService {
    ResponseEntity<List<ClassDto>> findAll();

    ResponseEntity<ClassDto> findById(Long classId);

    ResponseEntity<ClassDto> save(ClassDto classDto);

    ResponseEntity<Void> deleteById(Long classId) ;

    ResponseEntity<ClassDto> findClassByLabelClass(String labelClass);
    ResponseEntity<ClassDto> findClassByNameClass(String nameClass);
    ResponseEntity<List<ClassDto>> findAllByLevel(LevelDto dto);
}
