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

    @Column(name = "jourabsence")
    private String jourabsence;

    @Column(name = "datedebut")
    private Date datedebut;

    @Column(name = "dateFin")
    private Date dateFin;

    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    @JsonIgnore
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    @JsonIgnore
    private Eleve eleve;

}
