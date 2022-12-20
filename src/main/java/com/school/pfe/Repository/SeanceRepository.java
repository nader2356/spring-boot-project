package com.school.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.Timetable;

@Repository
public interface SeanceRepository extends JpaRepository<Timetable, Long>{

}
