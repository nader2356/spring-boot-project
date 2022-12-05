package com.school.pfe.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Service.TeacherService;

@RestController
@RequestMapping("api/school/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	@Autowired
	TeacherService teacherService;

	//Save new Teacher
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<TeacherDto> InsertTeacher(@Valid @RequestBody TeacherDto teacherDto) {
		TeacherDto teacherDtosaved = teacherService.save(teacherDto);
		return new ResponseEntity<TeacherDto>(teacherDtosaved, HttpStatus.CREATED);
	}
	//Delete Teacher
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		teacherService.delete(id);
	}
	//All Teacher
	@GetMapping("/listerEncadreur")
	public List<TeacherDto> liste() {
		// TODO Auto-generated method stub
		return teacherService.findAll();
	}
	//Get Teacher By Id
	@GetMapping("/findTeacher/{id}")
	public TeacherDto findTeacher(@PathVariable Long id) {
		return teacherService.teacherById(id);
	}

}
