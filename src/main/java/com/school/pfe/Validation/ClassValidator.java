package com.school.pfe.Validation;

import com.school.pfe.Dto.ClassDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClassValidator {

    public static List<String> validate(ClassDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the name of the class");
            errors.add("please fill in the label of the class");
            errors.add("Please select the level");
            errors.add("Please select the TimeTable");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNameClass())) {
            errors.add("please fill in the name of the class");
        }
        if (!StringUtils.hasLength(dto.getLabelClass())) {
            errors.add("please fill in the label of the class");
        }
       /* if (dto.TimeTable() == null || dto.getTimeTableDto().getId()==null) {
            errors.add("Please select the TimeTable");
        }*/
        if (dto.getLevel() == null || dto.getLevel().getId()==null) {
            errors.add("Please select the level");
        }
        return errors;
    }

}
