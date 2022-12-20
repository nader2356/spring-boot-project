package com.school.pfe.Service;

import org.springframework.http.ResponseEntity;

import com.school.pfe.Dto.TimetableDto;
import com.school.pfe.Model.Timetable;

public interface TimetableService {
	TimetableDto save(TimetableDto timetableDto);

	TimetableDto timetableById(Long idTimetable);

	ResponseEntity<Void> delete(Long id);

	Timetable save(Timetable planing);
}
