package com.school.pfe.Service;

import com.school.pfe.Dto.TimeTableDto;
import org.springframework.http.ResponseEntity;

public interface TimetableService {
	TimeTableDto save(TimeTableDto timetableDto);

	TimeTableDto timetableById(Long idTimetable);

	ResponseEntity<Void> delete(Long id);

}





