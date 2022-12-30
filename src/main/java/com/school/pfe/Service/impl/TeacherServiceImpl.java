package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.school.pfe.Dto.SubjectDto;
import com.school.pfe.Dto.TeacherValueDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Subject;
import com.school.pfe.Validation.SubjectValidation;
import com.school.pfe.Validation.TeacherValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Model.Teacher;
import com.school.pfe.Repository.TeacherRepository;
import com.school.pfe.Service.TeacherService;
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;

	
	@Override
	public TeacherDto save(TeacherDto teacherDto) {
		List<String> errors = TeacherValidation.validate(teacherDto);

		if (!errors.isEmpty()) {
			log.error("teacher is not valid {}", teacherDto);
			throw new InvalidEntityException("Le professeur n'est pas valide", ErrorCodes.TEACHER_NOT_VALID, errors);
		}
		return TeacherDto.entityToDto(
				teacherRepository.save(
						TeacherDto.dtoToEntity(teacherDto)
				)
		);
	}

	@Override
	public TeacherDto findById(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de trouver un professeur avec un ID NULL", ErrorCodes.TEACHER_ID_IS_NULL);
		}
		Optional<Teacher> teacher = teacherRepository.findById(id);

		return Optional.of(TeacherDto.entityToDto(teacher.get())).orElseThrow(() ->
				new EntityNotFoundException(
						"Aucun professeur avec l'ID = " + id + " n'a été trouvé dans la BDD",
						ErrorCodes.TEACHER_NOT_FOUND)
		);
	}


	@Override
	public TeacherValueDto teacherById(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de trouver un professeur avec un ID NULL", ErrorCodes.TEACHER_ID_IS_NULL);
		}
		Optional<Teacher> teacher = teacherRepository.findById(id);

		return Optional.of(TeacherValueDto.entityToDto(teacher.get())).orElseThrow(() ->
				new EntityNotFoundException(
						"Aucun professeur avec l'ID = " + id + " n'a été trouvé dans la BDD",
						ErrorCodes.TEACHER_NOT_FOUND)
		);
		 }

	@Override
	public List<TeacherDto> findAll() {
		return teacherRepository.findAll().stream()
				.map(TeacherDto::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de supprimer un professeur  avec un ID NULL",ErrorCodes.TEACHER_ID_IS_NULL);
		}
		teacherRepository.deleteById(id);
	}

}
