package com.school.pfe.Controller;


import javax.validation.Valid;

import com.school.pfe.Dto.TimeTableDto;
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

import com.school.pfe.Model.Seance;
import com.school.pfe.Service.impl.TimeTableServiceImpl;
import static com.school.pfe.Utils.Constants.TIME_TABLE_ENDPOINT;
@RestController
@RequestMapping(TIME_TABLE_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class TimetableController {

	@Autowired
	TimeTableServiceImpl timetableService;

	//Save new Timetable
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<TimeTableDto> InsertTimetable(@Valid @RequestBody TimeTableDto timetableDto) {

		return new ResponseEntity<>(timetableService.save(timetableDto), HttpStatus.CREATED);
	}
	
	
	//Affect new Seance to Timetable
	@PostMapping("/affectSeanceToTimetable/{idPlanning}/{idProf}/{idClassroom}")
	public String affectSeanceToTimetable(@Valid @RequestBody Seance seance, @PathVariable Long idPlanning,@PathVariable Long idProf, @PathVariable long idClassroom) {
		return timetableService.addSeanceToPlanning(seance, idPlanning, idProf, idClassroom);

	}
	
	//Delete Timetable
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		timetableService.delete(id);
	}

	//Get Timetable By Id
	@GetMapping("/findTimetable/{id}")
	public TimeTableDto findTimetable(@PathVariable Long id) {
		return timetableService.timetableById(id);
	}
}
