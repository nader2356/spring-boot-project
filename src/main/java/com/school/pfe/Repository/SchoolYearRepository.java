package com.school.pfe.Repository;


import com.school.pfe.Model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
    Optional<SchoolYear> findSchoolYearByYear(String year);

}
