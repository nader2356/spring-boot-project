package com.school.pfe.Dto;

import com.school.pfe.Model.*;

import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@Builder
@Data
public class StudentDto {
    private Long id ;
    @NotNull(message="It should be not null")
    private String firsName;

    @NotNull(message="It should be not null")
    private String lastName;
    private Date dateOfBirth;
    private String email;
    @Pattern(regexp="^[0-9]{8}$",message="it should be a number de 8 chiffre")
    private String telNum;
    @Size(min=2, max=50)
    private String adress;

    private List<InscriptionDto> listInscription;
    private List<AbsenceDto> listAbsence;
    private ClassDto classe;


    public static StudentDto fromEntity(Student student) {
        if (student == null) {
            return null;

        }
        return StudentDto.builder()

                .firsName(student.getFirsName())
                .lastName(student.getLastName())
                .dateOfBirth(student.getDateOfBirth())
                .email(student.getEmail())
                .telNum(student.getTelNum())
                .adress(student.getAdress())
                .id(student.getId())
                .classe(ClassDto.fromEntity(student.getClasse()))
                .build();
    }


    public static Student toEntity(StudentDto studentDto){
        if(studentDto==null){
            return null;
        }
        Student student=new Student();

        student.setId(studentDto.getId());
        student.setFirsName(studentDto.getFirsName());
        student.setLastName(studentDto.getLastName());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setEmail(studentDto.getEmail());
        student.setTelNum(studentDto.getTelNum());
        student.setAdress(studentDto.getAdress());
        student.setClasse(ClassDto.toEntity(studentDto.getClasse()));


        return student;
    }

}
