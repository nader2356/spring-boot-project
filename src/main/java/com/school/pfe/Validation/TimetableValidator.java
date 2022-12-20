package com.school.pfe.Validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.school.pfe.Dto.TimetableDto;

public class TimetableValidator {

	public static List<String> validate(TimetableDto timetableDto) {

        List<String> errors = new ArrayList<>();

        if (timetableDto == null) {
            errors.add("Veuillez renseigner les données nécessaires.");
        }
        else {

            if (timetableDto.getClassTeam() == null) {
                errors.add("Veuillez renseigner la classe.");
            }
            
        }

        return errors;
    }
}
