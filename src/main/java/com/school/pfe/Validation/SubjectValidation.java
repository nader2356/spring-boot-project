package com.school.pfe.Validation;

import com.school.pfe.Dto.SubjectDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SubjectValidation {

    public static List<String> validate(SubjectDto subjectDto) {

        List<String> errors = new ArrayList<>();

        if (subjectDto == null) {
            errors.add("Veuillez renseigner le nom du matière");
            errors.add("Veuillez renseigner le coefficient du matière");
            errors.add("Veuillez sélectionner un niveau");
        }
        else {

            if (!StringUtils.hasLength(subjectDto.getName())) {
                errors.add("Veuillez renseigner le nom du matière");
            }
            if (subjectDto.getCoefficient() == null) {
                errors.add("Veuillez renseigner le coefficient du matière");
            }
            if (subjectDto.getLevel() == null) {
                errors.add("Veuillez sélectionner un niveau");
            }
        }

        return errors;
    }
}
