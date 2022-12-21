package com.school.pfe.Validation;

import java.util.ArrayList;
import java.util.List;

import com.school.pfe.Dto.TimeTableDto;
import org.springframework.util.StringUtils;



public class TimetableValidator {

	public static List<String> validate(TimeTableDto timetableDto) {

        List<String> errors = new ArrayList<>();

        if (timetableDto == null) {
            errors.add("Veuillez renseigner les données nécessaires.");
        }
        else {

            if (timetableDto.getClass() == null) {
                errors.add("Veuillez renseigner la classe.");
            }
            
        }

        return errors;
    }
}
