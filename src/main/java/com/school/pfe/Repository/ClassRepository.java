package com.school.pfe.Repository;

import com.school.pfe.Model.Class;
import com.school.pfe.Model.Level;
import com.school.pfe.Model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findClassByLabelClass(String labelClass);
    Optional<Class> findClassByNameClass(String nameClass);
    List<Class> findAllByLevel(Level level);

}
