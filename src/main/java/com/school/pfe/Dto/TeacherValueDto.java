package com.school.pfe.Dto;

import com.school.pfe.Model.Teacher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class TeacherValueDto {
    private Long id;
    @NotNull(message="It should be not null")
    private String firsName;
    @NotNull(message="It should be not null")
    private String lastName;
    private AddressDto address;
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message="it should be an email ")
    private String email;
    @Pattern(regexp="^[0-9]{8}$",message="it should be a number de 8 chiffre")
    private String telephone;


    private String image;
    private SubjectIdDto subject;
    public static Teacher dtoToEntity(TeacherValueDto teacherValueDto) {
        Teacher teacher = new Teacher();
        if(teacherValueDto.getId()!=null)
        {
            teacher.setId(teacherValueDto.getId());
        }

        teacher.setFirsName(teacherValueDto.getFirsName());
        teacher.setLastName(teacherValueDto.getLastName());
        teacher.setAddress(AddressDto.toEntity(teacherValueDto.getAddress()));
        teacher.setEmail(teacherValueDto.getEmail());
        teacher.setTelephone(teacherValueDto.getTelephone());
        teacher.setImage(teacherValueDto.getImage());
        teacher.setSubject(SubjectIdDto.fromDtoToEntity(teacherValueDto.getSubject()));
        return teacher;
    }
    public static TeacherValueDto entityToDto(Teacher teacher) {
        TeacherValueDto teacherDto = new TeacherValueDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setFirsName(teacher.getFirsName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setAddress(AddressDto.fromEntity(teacher.getAddress()));
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setTelephone(teacher.getTelephone());
        teacherDto.setImage(teacher.getImage());
        teacherDto.setSubject(SubjectIdDto.fromEntity(teacher.getSubject()));


        return teacherDto;
    }
    public static List<TeacherDto> entityToDto(List<Teacher> listTeacher) {
        return listTeacher.stream().map(TeacherDto::entityToDto).collect(Collectors.toList());
    }

    public static List<Teacher> dtoToEntity(List<TeacherDto> teacherDto) {
        return teacherDto.stream().map(TeacherDto::dtoToEntity).collect(Collectors.toList());
    }
}
