package com.school.pfe.Validation;

import com.school.pfe.Dto.FacultyDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FacultyValidation {

    public static List<String> validate(FacultyDto facultyDto) {

        List<String> errors = new ArrayList<>();

        if (facultyDto == null) {
            errors.add("Veuillez renseigner le code du filière");
            errors.add("Veuillez renseigner le titre du filière");
        }
        else {

            if (!StringUtils.hasLength(facultyDto.getCode())) {
                errors.add("Veuillez renseigner le code du filière");
            }
            if (!StringUtils.hasLength(facultyDto.getLabel())) {
                errors.add("Veuillez renseigner le titre du filière");
            }
        }

        return errors;
    }
}
