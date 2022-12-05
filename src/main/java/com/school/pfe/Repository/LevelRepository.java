package com.school.pfe.Repository;

import com.school.pfe.Model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {

    Optional<Level> findLevelByCode(String code);

}
