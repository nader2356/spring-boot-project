package com.school.pfe.Validation;

import com.school.pfe.Dto.LevelDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class LevelValidation {

    public static List<String> validate(LevelDto levelDto)
    {

        List<String> errors = new ArrayList<>() ;

        if(levelDto== null)
        {

            errors.add("Veuillez renseigner le code du niveau");
            errors.add("Veuillez renseigner la designation du niveau");
            errors.add("Veuillez renseigner la filière du niveau");

        }

        else {

            if(!StringUtils.hasLength(levelDto.getCode()))
            {
                errors.add("Veuillez renseigner le code du niveau");
            }

            if(!StringUtils.hasLength(levelDto.getLabel()))
            {
                errors.add("Veuillez renseigner la designation du niveau");
            }

            if(levelDto.getSection() == null)
            {
                errors.add("Veuillez renseigner la filière du niveau");
            }

        }

        return errors ;
    }

}
