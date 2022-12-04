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

    @Column(name = "jourAbsence")
    private String jourAbsence;

    @Column(name = "DateDebut")
    private Date dateDebut;

    @Column(name = "DateFin")
    private Date dateFin;

    @Column(name = "Type")
    private String type;
    
    /*@ManyToOne
    @JoinColumn(name = "matiere_Id")
    @JsonIgnore
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "eleve_Id")
    @JsonIgnore
    private Eleve eleve;*/

}
