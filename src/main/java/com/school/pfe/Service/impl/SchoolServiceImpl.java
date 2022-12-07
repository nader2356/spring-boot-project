package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.school.pfe.Dto.ConvertSchool;
import com.school.pfe.Dto.SchoolDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.School;
import com.school.pfe.Repository.SchoolRepository;
import com.school.pfe.Service.SchoolService;
import com.school.pfe.Validation.SchoolValidation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDto save(SchoolDto schoolDto) {

        List<String> errors = SchoolValidation.validate(schoolDto);

        if (!errors.isEmpty()) {
            log.error("school is not valid {}", schoolDto);
            throw new InvalidEntityException("l'ecole n'est pas valide", ErrorCodes.SCHOOL_NOT_VALID, errors);
        }
        return ConvertSchool.entityToDto(
                schoolRepository.save(
                        ConvertSchool.dtoToEntity(schoolDto)
                )
        );

    }

    @Override
    public SchoolDto findById(Long id) {

        if (id == null) {
            log.error("School ID is null");
            throw new InvalidOperationException("Impossible de trouver une ecole avec un ID NULL", ErrorCodes.SCHOOL_ID_IS_NULL);
        }
        Optional<School> school = schoolRepository.findById(id);

        return Optional.of(ConvertSchool.entityToDto(school.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune ecole avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.SCHOOL_NOT_FOUND)
        );

    }

    @Override
    public SchoolDto findByName(String name) {

        if (!StringUtils.hasLength(name)) {
            log.error("School Name is null");
            throw new InvalidOperationException("Impossible de trouver une ecole avec un Nom NULL", ErrorCodes.SCHOOL_NAME_IS_NULL);
        }
        Optional<School> school = schoolRepository.findSchoolByName(name);

        return Optional.of(ConvertSchool.entityToDto(school.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune ecole avec le nom = " + name + " n'a été trouvée dans la BDD",
                        ErrorCodes.SCHOOL_NOT_FOUND)
        );

    }

    @Override
    public List<SchoolDto> findAll() {

        return schoolRepository.findAll().stream()
                .map(ConvertSchool::entityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            log.error("School ID is null");
            throw new InvalidOperationException("Impossible de supprimer une ecole  avec un ID NULL",ErrorCodes.SCHOOL_ID_IS_NULL);
        }
        schoolRepository.deleteById(id);

    }

}
