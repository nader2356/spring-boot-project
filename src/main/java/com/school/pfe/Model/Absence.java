package com.school.pfe.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}
