package com.school.pfe.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.pfe.Model.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long>{

		

}

