package com.school.pfe.Validation;

import java.util.ArrayList;
import java.util.List;

import com.school.pfe.Dto.SchoolDto;
import org.springframework.util.StringUtils;

public class SchoolValidation {

	public static List<String> validate(SchoolDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'ecole");
            errors.add("Veuillez renseigner l'adresse de l'ecole");
              return errors;
        }
        if (!StringUtils.hasLength(dto.getName())) {
            errors.add("Veuillez renseigner le nom de l'ecole");
        }
        if (!StringUtils.hasLength(dto.getAddress())) {
            errors.add("Veuillez renseigner l'adresse de l'ecole");
        }
        return errors;
    }
}
