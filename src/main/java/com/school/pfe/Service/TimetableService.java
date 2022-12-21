package com.school.pfe.Service;

import org.springframework.http.ResponseEntity;

import com.school.pfe.Dto.TimeTableDto;
import com.school.pfe.Model.TimeTable;

public interface TimetableService {
	TimeTableDto save(TimeTableDto timetableDto);

	TimeTableDto timetableById(Long idTimetable);

	ResponseEntity<Void> delete(Long id);

}





