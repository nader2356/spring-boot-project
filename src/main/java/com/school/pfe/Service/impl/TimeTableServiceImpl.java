package com.school.pfe.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.TimeTableDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.ClassRoom;
import com.school.pfe.Model.Level;
import com.school.pfe.Model.Seance;
import com.school.pfe.Model.Teacher;
import com.school.pfe.Model.TimeTable;
import com.school.pfe.Repository.ClassRoomRepository;
import com.school.pfe.Repository.TeacherRepository;
import com.school.pfe.Repository.TimetableRepository;
import com.school.pfe.Service.TeacherService;
import com.school.pfe.Service.TimetableService;
import com.school.pfe.Validation.LevelValidation;
import com.school.pfe.Validation.TimetableValidator;

@Service
public class TimeTableServiceImpl implements TimetableService{

	@Autowired
	private TimetableRepository planingRepository;

	@Autowired
	private TeacherRepository profRepository;

	@Autowired
	private ClassRoomRepository classroomRepository;

	@Autowired
	private TeacherRepository teacherRepository;


	public String addSeanceToPlanning(Seance seance, Long idPlanning, Long idProf, long idClassroom) {
		int numSeance= seance.getNumSeance();
		String day= seance.getDay();

		TimeTable planning = planingRepository.findById(idPlanning).orElse(null);
		if (planning == null) {
			return ("There is no planning with this id.");
		}

		Teacher prof = profRepository.findById(idProf).orElse(null);
		if (prof == null) {
			return ("There is no prof with this id.");
		}

		ClassRoom classroom = classroomRepository.findById(idClassroom).orElse(null);
		if (classroom == null) {
			return ("There is no classroom with this id.");
		}


		Boolean availabilityPlannig = verifyAvaillabilityPlanning(idPlanning, day, numSeance);
		if (availabilityPlannig == false) {
			return ("There is already a seance in the planning at this time!");
		}

		Boolean availabilityProf = verifyAvaillabilityProfessor(idProf, day, numSeance);
		if (availabilityProf == false) {
			return ("The teacher is not available!");
		}

		Boolean availabilityClassroom = verifyAvaillabilitySalle(idClassroom, day, numSeance);
		if (availabilityClassroom == false) {
			return ("The classroom is not available!");
		}


		//Appel à une méthode d'affectation de la séance au prof et à la salle et au planning et retourner un message de réussite d'ajout de la séance
		addSeanceToTeacher(seance, idProf);
		addSeanceToClassroom(seance, idClassroom);
		addSeanceToTimetable(seance, idPlanning);

		return ("Seance added succesfuly to the planning.");
	}



	public Boolean verifyAvaillabilityProfessor (long idProfessor, String day, int seanceNumber) {
		Teacher professor = profRepository.findById(idProfessor).orElse(null);
		if (professor == null){
			return false;
		} else {
			List<Seance> professorTimetable = professor.getTimetable();
			if(professorTimetable == null){
				return true;
			} else {
				int i = 0;
				while (i < professorTimetable.size()) {
					Seance seance = professorTimetable.get(i);
					if ((seance.getDay().compareTo(day)) == 0 && (seance.getNumSeance() == seanceNumber )) {
						return false;
					}
					i++;
				}

				return true;
			}
		}
	}


	public Boolean verifyAvaillabilitySalle (long idSalle, String day, int seanceNumber) {
		ClassRoom salle = classroomRepository.findById(idSalle).orElse(null);
		if (salle == null){
			return false;
		} else {
			List<Seance> salleTimetable = salle.getTimetable();
			if(salleTimetable == null){
				return true;
			} else {
				int i = 0;
				while (i < salleTimetable.size()) {
					Seance seance = salleTimetable.get(i);
					if ((seance.getDay().compareTo(day)) == 0 && (seance.getNumSeance() == seanceNumber )) {
						return false;
					}
					i++;
				}

				return true;
			}
		}
	}



	public Boolean verifyAvaillabilityPlanning (long idPlanning, String day, int seanceNumber) {
		TimeTable timetable = planingRepository.findById(idPlanning).orElse(null);
		if (timetable == null){
			return false;
		} else {
			List<Seance> timetablePlanning = timetable.getTimetablePlanning();
			if(timetablePlanning == null){
				return true;
			} else {
				int i = 0;
				while (i < timetablePlanning.size()) {
					Seance seance = timetablePlanning.get(i);
					if ((seance.getDay().compareTo(day)) == 0 && (seance.getNumSeance() == seanceNumber )) {
						return false;
					}
					i++;
				}

				return true;
			}
		}
	}





	public String addSeanceToClassroom(Seance seance, long idClassroom) {
		ClassRoom classroom = classroomRepository.findById(idClassroom).orElse(null);
		if (classroom == null){
			return ("Classroom not found!");
		} else {
			List<Seance> teacherTimeTable = classroom.getTimetable();
			teacherTimeTable.add(seance);
			classroom.setTimetable(teacherTimeTable);
			classroomRepository.save(classroom);
			return ("Seance added to the classroom's Time table!");
		}

	}

	public String addSeanceToTeacher(Seance seance, long idTeacher) {
		Teacher professor = teacherRepository.findById(idTeacher).orElse(null);
		if (professor == null){
			return ("Teacher not found!");
		} else {
			List<Seance> teacherTimeTable = professor.getTimetable();
			teacherTimeTable.add(seance);
			professor.setTimetable(teacherTimeTable);
			teacherRepository.save(professor);
			return ("Seance added to the teacher's Time table!");
		}
	}

	private String addSeanceToTimetable(Seance seance, Long idPlanning) {
		TimeTable timetable = planingRepository.findById(idPlanning).orElse(null);
		if (timetable == null){
			return ("Teacher not found!");
		} else {
			List<Seance> timeTablePlanning = timetable.geTimetablePlanning();
			timeTablePlanning.add(seance);
			timetable.setTimetablePlanning(timeTablePlanning);
			planingRepository.save(timetable);
			return ("Seance added to the timetable's Planning!");
		}


	}


	//=========================================================================================================

	@Override
	public TimeTableDto timetableById(Long idTimetable) {
		if(idTimetable == null)
		{
			log.error("Timetable ID is NULL ");
			throw new InvalidOperationException("Impossible de trouver un emploi de temps avec un ID NULL", ErrorCodes.TIMETABLE_ID_IS_NULL);
		}

		TimeTable timetable = planingRepository.findById(idTimetable).orElse(null);

		return TimeTableDto.fromEntity(timetable);
	}

	@Override
	public ResponseEntity<Void> delete(Long timetableId) {

		if(timetableId == null)
		{
			log.error("Timetable ID is NULL ");
			throw new InvalidOperationException("Impossible de supprimer un emploi du temps  avec un ID NULL",ErrorCodes.TIMETABLE_ID_IS_NULL);

		}

		planingRepository.deleteById(timetableId);
		return ResponseEntity.ok().build();

	}

	@Override
	public TimeTableDto save(TimeTableDto timetableDto) {
		List<String> errors = TimetableValidator.validate(timetableDto);

		if(!errors.isEmpty())
		{
			log.error("TimeTable is not valid {}" , timetableDto);
			throw new InvalidEntityException("l'emploi du temps n'est pas valide" , ErrorCodes.LEVEL_NOT_VALID,errors);
		}

		TimeTable timetable = TimeTableDto.toEntity(timetableDto);
		TimeTable timetableSaved = planingRepository.save(timetable);

		return TimeTableDto.fromEntity(timetableSaved);
	}

}