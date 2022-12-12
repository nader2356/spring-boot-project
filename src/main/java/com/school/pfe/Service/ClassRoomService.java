package com.school.pfe.Service;

import java.util.List;

import com.school.pfe.Dto.ClassRoomDto;


public interface ClassRoomService {
	

	ClassRoomDto save(ClassRoomDto classRoomDto);

	ClassRoomDto findById(Long id);

	    List<ClassRoomDto> findAll();

	    void delete(Long id);

}
