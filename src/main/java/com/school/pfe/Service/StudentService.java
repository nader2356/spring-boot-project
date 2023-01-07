package com.school.pfe.Service;


import com.school.pfe.Dto.StudentDto;
import com.school.pfe.Dto.StudentValueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    ResponseEntity<StudentDto> save(StudentDto dto);
    ResponseEntity<StudentValueDto> getbyid(Long id);
    ResponseEntity<StudentDto> findbyId(Long id);

    ResponseEntity<List<StudentDto>> findAll();
    void delete(Long id);
    ResponseEntity<StudentDto> uploadImageStudent(Long studentId, MultipartFile image);
}
