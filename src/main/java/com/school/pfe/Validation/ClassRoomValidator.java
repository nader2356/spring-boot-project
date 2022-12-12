package com.school.pfe.Validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.school.pfe.Dto.ClassRoomDto;





public class ClassRoomValidator {
	public static List<String> validate(ClassRoomDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("please fill in the classRoomNumber");
            errors.add("please fill in the bloc name");
            errors.add("please fill in the school ");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getClassRoomNumber())) {

            errors.add("please fill in the classRoomNumber");
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

