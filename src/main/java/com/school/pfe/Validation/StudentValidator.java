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

            errors.add("Veuillez renseigner l'adresse d'élève");
            errors.add("Veuillez renseigner l'email d'élève");
            errors.add("Veuillez renseigner le prenom d'élève");
            errors.add("Veuillez renseigner le nom d'élève");
            errors.add("Veuillez renseigner le numéro de téléphone d'élève");
            errors.add("Veuillez renseigner la date de naissance d'élève");
            errors.add("Veuillez sélectionner une classe");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getEmail())) {

            errors.add("Veuillez renseigner l'email d'élève");
        }
        if (!StringUtils.hasLength(dto.getFirsName())) {

            errors.add("Veuillez renseigner le prenom d'élève");
        }
        if (!StringUtils.hasLength(dto.getLastName())) {

            errors.add("Veuillez renseigner le nom d'élève");
        }
        if (!StringUtils.hasLength(dto.getTelNum())) {

            errors.add("Veuillez renseigner le numéro de téléphone d'élève");
        }
        if (dto.getDateOfBirth() == null) {

            errors.add("Veuillez renseigner la date de naissance d'élève");
        }
        if (dto.getClasse() == null) {
            errors.add("Veuillez sélectionner une classe");
        }

        errors.addAll(AddressValidator.validate(dto.getAddress()));
        return errors;
    }
}
