package com.school.pfe.Controller;

import javax.servlet.http.HttpServletRequest;
import com.school.pfe.Dto.StudentDto;
import com.school.pfe.Dto.StudentValueDto;
import com.school.pfe.Service.ImageStorage;
import com.school.pfe.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import javax.validation.Valid;
import java.util.List;

import static com.school.pfe.Utils.Constants.STUDENT_ENDPOINT;

@RestController
@RequestMapping(value = STUDENT_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    @Autowired
    @Qualifier("StudentImageStorageImpl")
    ImageStorage imageStorage;
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @PostMapping("/addOrUpdate")
    public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);

    }
    @PostMapping("/uploadStudentImage/{id}")
    public ResponseEntity<StudentDto> uploadStudentImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) {
        return this.studentService.uploadImageStudent(id, image);
    }
    @GetMapping("/downloadStudentImage/{imageName}")
    public ResponseEntity<Resource> downloadStudentImage(@PathVariable String imageName, HttpServletRequest request) {
        return this.imageStorage.downloadUserImage(imageName, request);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void delete(@PathVariable Long id) {

        studentService.delete(id);
    }

    @GetMapping("/listeStudent")
    public ResponseEntity<List<StudentDto>> liste() {

        return studentService.findAll();
    }

    @GetMapping("/findStudent/{id}")
    public ResponseEntity<StudentDto> findbyId(@PathVariable Long id) {

        return studentService.findbyId(id);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<StudentValueDto> getbyid(@PathVariable Long id) {

        return studentService.getbyid(id);
    }

}
