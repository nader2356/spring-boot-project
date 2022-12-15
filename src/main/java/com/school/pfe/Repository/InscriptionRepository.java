package com.school.pfe.Repository;

import java.util.Optional;

import com.school.pfe.Model.Inscription;
import com.school.pfe.Model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.School;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
