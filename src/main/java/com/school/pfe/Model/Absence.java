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

    private Date dateAbsence;
    private String type;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;
    @ManyToOne
    private Seance seance;

}
