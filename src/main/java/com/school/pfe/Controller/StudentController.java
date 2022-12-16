package com.school.pfe.Controller;


import com.school.pfe.Dto.StudentDto;
import com.school.pfe.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.school.pfe.Utils.Constants.STUDENT_ENDPOINT;

@RestController
@RequestMapping(value = STUDENT_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @PostMapping("/addOrUpdate")
    public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto studentDto) {
        StudentDto studentDTOsaved = studentService.save(studentDto);
        return new ResponseEntity<StudentDto>(studentDTOsaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void delete(@PathVariable Long id) {

        studentService.delete(id);
    }

    @GetMapping("/listeStudent")
    public List<StudentDto> liste() {

        return studentService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public StudentDto getbyid(@PathVariable Long id) {

        return studentService.findbyId(id);
    }

}
