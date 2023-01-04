package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.school.pfe.Dto.TeacherValueDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Service.ImageStorage;
import com.school.pfe.Validation.TeacherValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Model.Teacher;
import com.school.pfe.Repository.TeacherRepository;
import com.school.pfe.Service.TeacherService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;

	/*@Autowired
	private ImageStorage imageStorage;*/

	
	@Override
	public ResponseEntity<TeacherDto> save(TeacherDto teacherDto) {
		List<String> errors = TeacherValidation.validate(teacherDto);

		if (!errors.isEmpty()) {
			log.error("teacher is not valid {}", teacherDto);
			throw new InvalidEntityException("Le professeur n'est pas valide", ErrorCodes.TEACHER_NOT_VALID, errors);
		}
		return ResponseEntity.ok(TeacherDto.entityToDto(
				teacherRepository.save(
						TeacherDto.dtoToEntity(teacherDto)
				)
		));
	}

	@Override
	public ResponseEntity<TeacherDto> findById(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de trouver un professeur avec un ID NULL", ErrorCodes.TEACHER_ID_IS_NULL);
		}
		Optional<Teacher> teacher = teacherRepository.findById(id);

		return ResponseEntity.ok(Optional.of(TeacherDto.entityToDto(teacher.get())).orElseThrow(() ->
				new EntityNotFoundException(
						"Aucun professeur avec l'ID = " + id + " n'a été trouvé dans la BDD",
						ErrorCodes.TEACHER_NOT_FOUND)
		));
	}


	@Override
	public ResponseEntity<TeacherValueDto> teacherById(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de trouver un professeur avec un ID NULL", ErrorCodes.TEACHER_ID_IS_NULL);
		}
		Optional<Teacher> teacher = teacherRepository.findById(id);

		return ResponseEntity.ok(Optional.of(TeacherValueDto.entityToDto(teacher.get())).orElseThrow(() ->
				new EntityNotFoundException(
						"Aucun professeur avec l'ID = " + id + " n'a été trouvé dans la BDD",
						ErrorCodes.TEACHER_NOT_FOUND)
		));
		 }

	@Override
	public ResponseEntity<List<TeacherDto>> findAll() {
		return ResponseEntity.ok(teacherRepository.findAll().stream()
				.map(TeacherDto::entityToDto)
				.collect(Collectors.toList()));
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Teacher ID is null");
			throw new InvalidOperationException("Impossible de supprimer un professeur  avec un ID NULL",ErrorCodes.TEACHER_ID_IS_NULL);
		}
		teacherRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<TeacherDto> uploadImageTeacher(Long teacherId, MultipartFile image) {
		ResponseEntity<TeacherDto> teacherResponse = this.findById(teacherId);
		//String imageName=imageStorage.store(image);
		//String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/school/teacher/downloadTeacherImage/").path(imageName).toUriString();
		TeacherDto teacherDto = teacherResponse.getBody();
		//if (teacherDto!=null)
			//teacherDto.setImage(fileImageDownloadUrl);

		return this.save(teacherDto);
	}

}
