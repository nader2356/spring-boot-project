package com.school.pfe.Validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.school.pfe.Dto.SalleDTO;



public class SalleValidator {
	public static List<String> validate(SalleDTO dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("please fill in the salle number");
            errors.add("please fill in the bloc name");
            errors.add("please fill in the school ");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getSalleNumber())) {

            errors.add("please fill in the salle number");
        }
        if (!StringUtils.hasLength(dto.getBloc())) {

            errors.add("please fill in the bloc name");
        }
        if (dto.getSchool() == null) {
            errors.add("please fill in the school");
        }
        return errors;
    }

}

