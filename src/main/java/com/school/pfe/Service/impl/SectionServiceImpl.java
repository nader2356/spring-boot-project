package com.school.pfe.Service.impl;

import com.school.pfe.Dto.SectionDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Section;
import com.school.pfe.Repository.SectionRepository;
import com.school.pfe.Service.SectionService;
import com.school.pfe.Validation.SectionValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) { this.sectionRepository = sectionRepository; }

    @Override
    public SectionDto save(SectionDto sectionDto) {

        List<String> errors = SectionValidation.validate(sectionDto);

        if (!errors.isEmpty()) {
            log.error("section is not valid {}", sectionDto);
            throw new InvalidEntityException("La filière n'est pas valide", ErrorCodes.SECTION_NOT_VALID, errors);
        }
        return SectionDto.fromEntity(
                sectionRepository.save(
                        SectionDto.toEntity(sectionDto)
                )
        );

    }

    @Override
    public SectionDto findById(Long id) {

        if (id == null) {
            log.error("Section ID is null");
            throw new InvalidOperationException("Impossible de trouver une filière avec un ID NULL", ErrorCodes.SECTION_ID_IS_NULL);
        }
        Optional<Section> section = sectionRepository.findById(id);

        return Optional.of(SectionDto.fromEntity(section.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune filière avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.SECTION_NOT_FOUND)
        );

    }

    @Override
    public SectionDto findByCode(String code) {

        if (!StringUtils.hasLength(code)) {
            log.error("Section CODE is null");
            throw new InvalidOperationException("Impossible de trouver une filière avec un CODE NULL", ErrorCodes.SECTION_CODE_IS_NULL);
        }
        Optional<Section> section = sectionRepository.findSectionByCode(code);

        return Optional.of(SectionDto.fromEntity(section.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune filière avec le CODE = " + code + " n'a été trouvée dans la BDD",
                        ErrorCodes.SECTION_NOT_FOUND)
        );

    }

    @Override
    public List<SectionDto> findAll() {

        return sectionRepository.findAll().stream()
                .map(SectionDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            log.error("Section ID is null");
            throw new InvalidOperationException("Impossible de supprimer une filière  avec un ID NULL",ErrorCodes.SECTION_ID_IS_NULL);
        }
        sectionRepository.deleteById(id);

    }
}
