package com.school.pfe.Service;

import java.util.List;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Dto.TeacherValueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface TeacherService {
    ResponseEntity<TeacherDto> save(TeacherDto teacherDto);

    ResponseEntity<TeacherDto> findById(Long id);

    ResponseEntity<TeacherValueDto> teacherById(Long id);

    ResponseEntity<List<TeacherDto>> findAll();

    void delete(Long id);

    ResponseEntity<TeacherDto> uploadImageTeacher(Long teacherId, MultipartFile image);
}
