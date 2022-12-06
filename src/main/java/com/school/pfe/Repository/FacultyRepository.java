package com.school.pfe.Repository;

import com.school.pfe.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findFacultyByCode(String code);

}
