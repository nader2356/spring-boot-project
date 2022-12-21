package com.school.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long>{

}
