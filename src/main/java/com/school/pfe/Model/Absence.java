package com.school.pfe.Model;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
>>>>>>> b6c7a0cf88ae0d82b498a7cb37a048190bafef2e

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
<<<<<<< HEAD
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idAbscene;
    private String jourAbsence;
    private Date DateDebut;
    private Date DateFin;
    private String Type;
=======
public class Absence extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAbscene")
    private Integer idAbscene;

    @Column(name = "jourAbsence")
    private String jourAbsence;

    @Column(name = "DateDebut")
    private Date DateDebut;

    @Column(name = "DateFin")
    private Date DateFin;

    @Column(name = "Type")
    private String Type;
    @ManyToOne
    @JoinColumn(name = "matiere_Id")
    @JsonIgnore
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "eleve_Id")
    @JsonIgnore
    private Eleve eleve;
>>>>>>> b6c7a0cf88ae0d82b498a7cb37a048190bafef2e

}
