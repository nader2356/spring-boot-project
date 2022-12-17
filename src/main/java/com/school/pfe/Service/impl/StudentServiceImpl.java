package com.school.pfe.Service.impl;


import com.school.pfe.Dto.StudentDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Repository.StudentRepository;
import com.school.pfe.Service.StudentService;

import com.school.pfe.Validation.StudentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto save(StudentDto dto) {
        List<String> errors = StudentValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("student is not valid{}", dto);
            throw new InvalidEntityException("student is not validate", ErrorCodes.STUDENT_NOT_VALID, errors);
        }

        return StudentDto.fromEntity(studentRepository.save(StudentDto.toEntity(dto)));
    }

    @Override
    public StudentDto findbyId(Long id) {
        if (id == null) {
            log.error("student ID is null");
            return null;
        }
        return studentRepository.findById(id).map(StudentDto::fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "No student with ID=" + id + " is not found in the BDD",
                        ErrorCodes.STUDENT_NOT_FOUND
                ));
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(StudentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("student ID is null");
            return;
        }
        studentRepository.deleteById(id);
    }
}
