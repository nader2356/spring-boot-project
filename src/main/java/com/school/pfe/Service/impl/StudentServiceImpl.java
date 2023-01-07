package com.school.pfe.Service.impl;


import com.school.pfe.Dto.StudentDto;
import com.school.pfe.Dto.StudentValueDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Repository.StudentRepository;
import com.school.pfe.Service.ImageStorage;
import com.school.pfe.Service.StudentService;

import com.school.pfe.Validation.StudentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Qualifier("StudentImageStorageImpl")
    @Autowired
    private ImageStorage imageStorage;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<StudentDto> save(StudentDto dto) {
        List<String> errors = StudentValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("student is not valid{}", dto);
            throw new InvalidEntityException("student is not validate", ErrorCodes.STUDENT_NOT_VALID, errors);
        }

        return ResponseEntity.ok(StudentDto.fromEntity(studentRepository.save(StudentDto.toEntity(dto))));
    }

    @Override
    public ResponseEntity<StudentValueDto> getbyid(Long id) {
        if (id == null) {
            log.error("student ID is null");
            return null;
        }
        return ResponseEntity.ok(studentRepository.findById(id).map(StudentValueDto::fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "No student with ID=" + id + " is not found in the BDD",
                        ErrorCodes.STUDENT_NOT_FOUND
                )));
    }

    @Override
    public ResponseEntity<StudentDto> findbyId(Long id) {
        if (id == null) {
            log.error("student ID is null");
            return null;
        }
        return ResponseEntity.ok(studentRepository.findById(id).map(StudentDto::fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "No student with ID=" + id + " is not found in the BDD",
                        ErrorCodes.STUDENT_NOT_FOUND
                )));
    }

    @Override
    public ResponseEntity<List<StudentDto>> findAll() {
        return ResponseEntity.ok(studentRepository.findAll().stream()
                .map(StudentDto::fromEntity)
                .collect(Collectors.toList()));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("student ID is null");
            return;
        }
        studentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<StudentDto> uploadImageStudent(Long studentId, MultipartFile image) {
        ResponseEntity<StudentDto> studentResponse = this.findbyId(studentId);
        String imageName=imageStorage.store(image);
        String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/school/student/downloadStudentImage/").path(imageName).toUriString();
        StudentDto studentDto = studentResponse.getBody();
        if (studentDto!=null)
            studentDto.setImage(fileImageDownloadUrl);

        return this.save(studentDto);
    }
}
