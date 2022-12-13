package com.school.pfe.Service.impl;

import com.school.pfe.Dto.SubjectDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Subject;
import com.school.pfe.Repository.SubjectRepository;
import com.school.pfe.Service.SubjectService;
import com.school.pfe.Validation.SubjectValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) { this.subjectRepository = subjectRepository; }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {

        List<String> errors = SubjectValidation.validate(subjectDto);

        if (!errors.isEmpty()) {
            log.error("subject is not valid {}", subjectDto);
            throw new InvalidEntityException("La matière n'est pas valide", ErrorCodes.SUBJECT_NOT_VALID, errors);
        }
        return SubjectDto.fromEntity(
                subjectRepository.save(
                        SubjectDto.toEntity(subjectDto)
                )
        );

    }

    @Override
    public SubjectDto findById(Long id) {

        if (id == null) {
            log.error("Subject ID is null");
            throw new InvalidOperationException("Impossible de trouver une matière avec un ID NULL", ErrorCodes.SUBJECT_ID_IS_NULL);
        }
        Optional<Subject> subject = subjectRepository.findById(id);

        return Optional.of(SubjectDto.fromEntity(subject.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune matière avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.SUBJECT_NOT_FOUND)
        );

    }

    @Override
    public SubjectDto findByName(String name) {

        if (!StringUtils.hasLength(name)) {
            log.error("Subject NAME is null");
            throw new InvalidOperationException("Impossible de trouver une matière avec un NOM NULL", ErrorCodes.SUBJECT_NAME_IS_NULL);
        }
        Optional<Subject> subject = subjectRepository.findSubjectByName(name);

        return Optional.of(SubjectDto.fromEntity(subject.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune matière avec le NOM = " + name + " n'a été trouvée dans la BDD",
                        ErrorCodes.SUBJECT_NOT_FOUND)
        );

    }

    @Override
    public List<SubjectDto> findAll() {

        return subjectRepository.findAll().stream()
                .map(SubjectDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            log.error("Subject ID is null");
            throw new InvalidOperationException("Impossible de supprimer une matière  avec un ID NULL",ErrorCodes.SUBJECT_ID_IS_NULL);
        }
        subjectRepository.deleteById(id);

    }
}
