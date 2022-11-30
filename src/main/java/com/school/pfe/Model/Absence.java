package com.school.pfe.Model;

import lombok.*;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idAbscene;
    private String jourAbsence;
    private Date DateDebut;
    private Date DateFin;
    private String Type;

}
