package com.school.pfe.Validation;

import com.school.pfe.Dto.SectionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SectionValidation {

    public static List<String> validate(SectionDto sectionDto) {

        List<String> errors = new ArrayList<>();

        if (sectionDto == null) {
            errors.add("Veuillez renseigner le code du filière");
            errors.add("Veuillez renseigner le titre du filière");
        }
        else {

            if (!StringUtils.hasLength(sectionDto.getCode())) {
                errors.add("Veuillez renseigner le code du filière");
            }
            if (!StringUtils.hasLength(sectionDto.getLabel())) {
                errors.add("Veuillez renseigner le titre du filière");
            }
        }

        return errors;
    }
}
