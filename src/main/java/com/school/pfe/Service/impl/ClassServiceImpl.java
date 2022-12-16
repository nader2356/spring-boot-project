package com.school.pfe.Service.impl;

import com.school.pfe.Dto.ClassDto;
import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.SchoolYearDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Class;
import com.school.pfe.Repository.ClassRepository;
import com.school.pfe.Service.ClassService;
import com.school.pfe.Validation.ClassValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClassServiceImpl implements ClassService {


    ClassRepository repository;

    public ClassServiceImpl(ClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<ClassDto> save(ClassDto entityDto) {
        List<String> errors = ClassValidator.validate(entityDto);

        if (!errors.isEmpty()) {
            log.error("class is not valid {}", entityDto);
            throw new InvalidEntityException("The class is invalid",ErrorCodes.CLASS_NOT_VALID, errors);
        }

        return ResponseEntity.ok(ClassDto.fromEntity(repository.save(
                ClassDto.toEntity(entityDto)
        )));
    }


    @Override
    public ResponseEntity<List<ClassDto>> findAll() {
        return  ResponseEntity.ok(repository.findAll().stream()
                .map(ClassDto::fromEntity)
                .collect(Collectors.toList()));
    }





    @Override
    public ResponseEntity<ClassDto> findById(Long id) {
        if (id == null) {
            log.error("Class ID is null");
            return null;
        }
        return  ResponseEntity.ok(repository.findById(id)
                .map(ClassDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No class with ID = " + id + " was not found in the DataBase", ErrorCodes.CLASS_NOT_FOUND)
                ));
    }
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (id == null) {
            log.error("Class ID is null");
            throw new InvalidOperationException("Unable to delete a class with a NULL ID",ErrorCodes.CLASS_CODE_IS_NULL);
        }

        Class entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No class with ID = " + id + " was not found in the DataBase", ErrorCodes.CLASS_NOT_FOUND)
        );
        repository.delete(entity);
        return  ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ClassDto> findClassByLabelClass(String labelClass) {
        if (labelClass == null) {
            log.error("label Class is null");
            return null;
        }
        return  ResponseEntity.ok(repository.findClassByLabelClass(labelClass)
                .map(ClassDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No class with label = " + labelClass + " was not found in the DataBase", ErrorCodes.CLASS_NOT_FOUND)
                ));
    }

    @Override
    public ResponseEntity<ClassDto> findClassByNameClass(String nameClass) {
        if (nameClass == null) {
            log.error("name Class is null");
            return null;
        }
        return  ResponseEntity.ok(repository.findClassByNameClass(nameClass)
                .map(ClassDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No class with name  = " + nameClass + " was not found in the DataBase", ErrorCodes.CLASS_NOT_FOUND)
                ));
    }



    @Override
    public ResponseEntity<List<ClassDto>> findAllByLevel(LevelDto dto) {
        return  ResponseEntity.ok(repository.findAllByLevel(LevelDto.toEntity(dto)).stream()
                .map(ClassDto::fromEntity)
                .collect(Collectors.toList()));    }


}
