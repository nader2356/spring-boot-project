package com.school.pfe.Service.impl;

import com.school.pfe.Dto.AbsenceDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Repository.AbsenceRepository;
import com.school.pfe.Service.AbsenceService;
import com.school.pfe.Validation.AbsenceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AbsenceServiceImpl implements AbsenceService {
    private AbsenceRepository absenceRepository;

    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public AbsenceDto save(AbsenceDto dto) {
        List<String> errors = AbsenceValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("absence is not valid{}", dto);
            throw new InvalidEntityException("absence n'est pas validé", ErrorCodes.ABSENCE_NOT_VALID, errors);
        }

        return AbsenceDto.fromEntity(absenceRepository.save(AbsenceDto.toEntity(dto)));
    }

    @Override
    public AbsenceDto findbyId(Long id) {
        if (id == null) {
            log.error("absence ID is null");
            return null;
        }
        return absenceRepository.findById(id).map(AbsenceDto::fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "Aucun absence avec l'ID =" + id + " n'est trouve dans le BDD",
                        ErrorCodes.ABSENCE_NOT_FOUND
                ));
    }

    @Override
    public List<AbsenceDto> findAll() {
        return absenceRepository.findAll().stream()
                .map(AbsenceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("absence ID is null");
            return;
        }
        absenceRepository.deleteById(id);


    }
}

