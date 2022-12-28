package com.school.pfe.Dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.school.pfe.Model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
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
	private SubjectDto subject;
	public static Teacher dtoToEntity(TeacherDto teacherDto) {
		Teacher teacher = new Teacher();
		if(teacherDto.getId()!=null)
		{
			teacher.setId(teacherDto.getId());
		}
		
		teacher.setFirsName(teacherDto.getFirsName());
		teacher.setLastName(teacherDto.getLastName());
		teacher.setAddress(AddressDto.toEntity(teacherDto.getAddress()));
		teacher.setEmail(teacherDto.getEmail());
		teacher.setTelephone(teacherDto.getTelephone());
		teacher.setSubject(SubjectDto.toEntity(teacherDto.getSubject()));
		return teacher;
	}
	public static TeacherDto entityToDto(Teacher teacher) {
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(teacher.getId());
		teacherDto.setFirsName(teacher.getFirsName());
		teacherDto.setLastName(teacher.getLastName());
		teacherDto.setAddress(AddressDto.fromEntity(teacher.getAddress()));
		teacherDto.setEmail(teacher.getEmail());
		teacherDto.setTelephone(teacher.getTelephone());
		teacherDto.setSubject(SubjectDto.fromEntity(teacher.getSubject()));

		
		return teacherDto;
	}
	public static List<TeacherDto> entityToDto(List<Teacher> listTeacher) {
	return listTeacher.stream().map(TeacherDto::entityToDto).collect(Collectors.toList());
	}

	public static List<Teacher> dtoToEntity(List<TeacherDto> teacherDto) {
		return teacherDto.stream().map(TeacherDto::dtoToEntity).collect(Collectors.toList());
	}
}
