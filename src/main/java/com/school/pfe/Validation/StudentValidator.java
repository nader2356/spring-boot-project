package com.school.pfe.Validation;

import com.school.pfe.Dto.AbsenceDto;
import com.school.pfe.Dto.StudentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public static List<String> validate(StudentDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {

            errors.add("please fill in the address");
            errors.add("please fill in the email");
            errors.add("please fill in the firstName");
            errors.add("please fill in the lastName");
            errors.add("please fill in the phone number ");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getAdress())) {

            errors.add("please fill in the address");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {

            errors.add("please fill in the email");
        }
        if (!StringUtils.hasLength(dto.getFirsName())) {

            errors.add("please fill in the firstName");
        }
        if (!StringUtils.hasLength(dto.getLastName())) {

            errors.add("please fill in the lastName");
        }
        if (!StringUtils.hasLength(dto.getTelNum())) {

            errors.add("please fill in the phone number ");
        }

        return errors;
    }
}
