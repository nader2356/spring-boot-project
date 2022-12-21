package com.school.pfe.Repository;

import com.school.pfe.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long>{

}
