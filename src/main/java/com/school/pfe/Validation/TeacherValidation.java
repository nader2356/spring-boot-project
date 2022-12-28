package com.school.pfe.Validation;

import com.school.pfe.Dto.TeacherDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TeacherValidation {

    public static List<String> validate(TeacherDto teacherDto) {

        List<String> errors = new ArrayList<>();

        if (teacherDto == null) {
            errors.add("Veuillez renseigner le nom du professeur");
            errors.add("Veuillez renseigner le prenom du professeur");
            errors.add("Veuillez renseigner l'adresse du professeur");
            errors.add("Veuillez renseigner l'email du professeur");
            errors.add("Veuillez renseigner le numéro de téléphone du professeur");
            errors.add("Veuillez sélectionner une matière");
        }
        else {

            if (!StringUtils.hasLength(teacherDto.getLastName())) {
                errors.add("Veuillez renseigner le nom du professeur");
            }
            if (!StringUtils.hasLength(teacherDto.getFirsName())) {
                errors.add("Veuillez renseigner le prenom du professeur");
            }

            if (!StringUtils.hasLength(teacherDto.getEmail())) {
                errors.add("Veuillez renseigner l'email du professeur");
            }
            if (!StringUtils.hasLength(teacherDto.getTelephone())) {
                errors.add("Veuillez renseigner le numéro de téléphone du professeur");
            }
            if (teacherDto.getSubject() == null) {
                errors.add("Veuillez sélectionner une matière");
            }
        }

        errors.addAll(AddressValidator.validate(teacherDto.getAddress()));
        return errors;
    }
}
