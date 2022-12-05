package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Model.Teacher;
import com.school.pfe.Repository.TeacherRepository;
import com.school.pfe.Service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private TeacherDto teacherDto;
	
	@Override
	public TeacherDto save(TeacherDto teacherDto) {
		Teacher teacher=TeacherDto.dtoToEntity(teacherDto);
		teacherRepository.save(teacher);
		TeacherDto teacherDtosaved=TeacherDto.entityToDto(teacher);
		return teacherDtosaved;
	}

	@Override
	public TeacherDto teacherById(Long id) {
		Optional<Teacher> optionalTeacher =teacherRepository.findById(id);
		 if (optionalTeacher.isPresent()) {
			 Teacher teacher=optionalTeacher.get();
				 return teacherDto.entityToDto(teacher);
		 }
		 else
			{
				return null;
			}
		 }

	@Override
	public List<TeacherDto> findAll() {
		return teacherDto.entityToDto(teacherRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		teacherRepository.deleteById(id);		
	}

}
