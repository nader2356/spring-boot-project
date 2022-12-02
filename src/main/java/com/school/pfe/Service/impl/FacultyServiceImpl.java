package com.school.pfe.Service.impl;

import com.school.pfe.Dto.FacultyDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Model.Faculty;
import com.school.pfe.Repository.FacultyRepository;
import com.school.pfe.Service.FacultyService;
import com.school.pfe.Validation.FacultyValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;

    public FacultyServiceImpl(
            FacultyRepository facultyRepository
    ) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyDto save(FacultyDto facultyDto) {
        List<String> errors = FacultyValidation.validate(facultyDto);
        if (!errors.isEmpty()) {
            log.error("faculty is not valid {}", facultyDto);
            throw new InvalidEntityException("La filière n'est pas valide", ErrorCodes.FACULTY_NOT_VALID, errors);
        }
        return FacultyDto.fromEntity(
                facultyRepository.save(
                        FacultyDto.toEntity(facultyDto)
                )
        );
    }

    @Override
    public FacultyDto findById(Integer id) {
        if (id == null) {
            log.error("Faculty ID is null");
            return null;
        }
        Optional<Faculty> faculty = facultyRepository.findById(id);

        return Optional.of(FacultyDto.fromEntity(faculty.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune filière avec l'ID = " + id + " n' ete trouvée dans la BDD",
                        ErrorCodes.FACULTY_NOT_FOUND)
        );
    }

    @Override
    public List<FacultyDto> findAll() {
        return facultyRepository.findAll().stream()
                .map(FacultyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Faculty ID is null");
            return;
        }
        facultyRepository.deleteById(id);

    }
}
