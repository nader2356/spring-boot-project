package com.school.pfe.Handler;


import com.school.pfe.Exception.ErrorCodes;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private String message;
    private ErrorCodes code;
    private List<String> errors;
}
