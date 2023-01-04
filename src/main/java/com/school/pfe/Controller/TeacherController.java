package com.school.pfe.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.school.pfe.Dto.TeacherValueDto;
import com.school.pfe.Service.ImageStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Service.TeacherService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/school/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	@Autowired
	TeacherService teacherService;

	@Autowired
	ImageStorage imageStorage;

	//Save new Teacher
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<TeacherDto> InsertTeacher(@Valid @RequestBody TeacherDto teacherDto) {
		return teacherService.save(teacherDto);
	}
	@PostMapping("/uploadTeacherImage/{id}")
	public ResponseEntity<TeacherDto> uploadTeacherImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) {
		return this.teacherService.uploadImageTeacher(id, image);
	}
	@GetMapping("/downloadTeacherImage/{imageName}")
	public ResponseEntity<Resource> downloadTeacherImage(@PathVariable String imageName, HttpServletRequest request) {
		return this.imageStorage.downloadTeacherImage(imageName, request);
	}
	//Delete Teacher
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		teacherService.delete(id);
	}
	//All Teacher
	@GetMapping("/listerEncadreur")
	public ResponseEntity<List<TeacherDto>> liste() {
		// TODO Auto-generated method stub
		return teacherService.findAll();
	}
	//Get Teacher By Id
	@GetMapping("/getTeacher/{id}")
	public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id) {
		return teacherService.findById(id);
	}
	@GetMapping("/findTeacher/{id}")
	public ResponseEntity<TeacherValueDto> findTeacher(@PathVariable Long id) {
		return teacherService.teacherById(id);
	}

}
