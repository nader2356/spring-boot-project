package com.school.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
