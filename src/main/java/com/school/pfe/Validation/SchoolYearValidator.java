package com.school.pfe.Validation;

import com.school.pfe.Dto.ClassDto;
import com.school.pfe.Dto.SchoolYearDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SchoolYearValidator {

    public static List<String> validate(SchoolYearDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the year of the school year");
            errors.add("please fill in the start Date semestre 1");
            errors.add("please fill in the end Date semestre 1");
            errors.add("please fill in the start Date semestre 2");
            errors.add("please fill in the end Date semestre 2");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getYear())) {
            errors.add("please fill in the year of the school year");
        }

        if (dto.getStartDateSemestre1() == null) {
            errors.add("please fill in the start Date semestre 1");
        }
        if (dto.getEndDateSemestre1()==null) {
            errors.add("please fill in the end Date semestre 1");
        }
        if (dto.getStartDateSemestre2() == null) {
            errors.add("please fill in the start Date semestre 1");
        }

        if (dto.getEndDateSemestre2() == null) {
            errors.add("please fill in the end Date semestre 2");
        }


        return errors;
    }
}
