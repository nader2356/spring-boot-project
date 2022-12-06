package com.school.pfe.Service.impl;

import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.SchoolYearDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Level;
import com.school.pfe.Model.SchoolYear;
import com.school.pfe.Repository.SchoolYearRepository;
import com.school.pfe.Service.SchoolYearService;
import com.school.pfe.Validation.SchoolYearValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SchoolYearServiceImp implements SchoolYearService {


     SchoolYearRepository repository;

    public SchoolYearServiceImp(SchoolYearRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<SchoolYearDto> save(SchoolYearDto entityDto) {
        List<String> errors = SchoolYearValidator.validate(entityDto);

        if (!errors.isEmpty()) {
            log.error("school year is not valid {}", entityDto);
            throw new InvalidEntityException("The school year is invalid", ErrorCodes.SCHOOL_YEAR_NOT_FOUND, errors);
        }

        return ResponseEntity.ok(SchoolYearDto.fromEntity(repository.save(
                SchoolYearDto.toEntity(entityDto)
        )));
    }


    @Override
    public ResponseEntity<List<SchoolYearDto>> findAll() {
        return  ResponseEntity.ok(repository.findAll().stream()
                .map(SchoolYearDto::fromEntity)
                .collect(Collectors.toList()));
    }





    @Override
    public ResponseEntity<SchoolYearDto> findById(Long id) {
        if (id == null) {
            log.error("school year ID is null");
            return null;
        }
        return  ResponseEntity.ok(repository.findById(id)
                .map(SchoolYearDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No school year with ID = " + id + " was not found in the DataBase", ErrorCodes.SCHOOL_YEAR_NOT_FOUND)
                ));
    }
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (id == null) {
            log.error("school year ID is null");
            throw new InvalidOperationException("Unable to delete a school year with a NULL ID",ErrorCodes.SCHOOL_YEAR_ID_IS_NULL);
        }

        SchoolYear entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No school year with ID = " + id + " was not found in the DataBase", ErrorCodes.SCHOOL_YEAR_NOT_FOUND)
        );
        repository.delete(entity);
        return  ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SchoolYearDto> findSchoolYearByYear(String year) {
        if(!StringUtils.hasLength(year))
        {
            log.error("school year year is NULL ");
            throw new InvalidOperationException("Unable to delete a school year with a NULL ID",ErrorCodes.SCHOOL_YEAR_ID_IS_NULL);
        }

        SchoolYear schoolYear=repository.findSchoolYearByYear(year).orElseThrow(() -> new EntityNotFoundException(
                "No school year with year = " + year + " was not found in the DataBase", ErrorCodes.SCHOOL_YEAR_NOT_FOUND)
        );
        return ResponseEntity.ok(SchoolYearDto.fromEntity(schoolYear));
    }
}
