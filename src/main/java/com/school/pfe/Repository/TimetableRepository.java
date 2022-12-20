package com.school.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.Timetable;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long>{

}
