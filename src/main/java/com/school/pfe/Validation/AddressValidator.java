package com.school.pfe.Validation;


import com.school.pfe.Dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> validate(AddressDto addressDto)
    {
        List<String> errors = new ArrayList<>() ;

        if(addressDto == null)
        {
            errors.add("Veuillez renseigner l'adresse 1");
            errors.add("Veuillez renseigner le code postal");
            errors.add("Veuillez renseigner la ville");
            errors.add("Veuillez renseigner le pays");

        } else
        {
            if(!StringUtils.hasLength(addressDto.getAddress1()))
            {
                errors.add("Veuillez renseigner l'adresse 1");
            }
            if(!StringUtils.hasLength(addressDto.getZipCode()))
            {
                errors.add("Veuillez renseigner le code postal");
            }
            if(!StringUtils.hasLength(addressDto.getCity()))
            {
                errors.add("Veuillez renseigner la ville");
            }
            if(!StringUtils.hasLength(addressDto.getCountry()))
            {
                errors.add("Veuillez renseigner le pays");
            }
        }

        return errors;
    }
}
