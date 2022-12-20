package com.school.pfe.Validation;

import com.school.pfe.Dto.AbsenceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AbsenceValidator {
    public static List<String> validate(AbsenceDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {

            errors.add("please fill in the type of absence");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getType())) {

            errors.add("please fill in the type of absence");
        }
        return errors;
    }}
