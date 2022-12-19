package com.school.pfe.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schoolYear")
public class SchoolYear extends AbstractEntity{

    @Column(name = "year")
    private String year;

    @Column(name = "startDateSemestre1")
    private Instant startDateSemestre1;

    @Column(name = "startDateSemestre2")
    private Instant startDateSemestre2;

    @Column(name = "endDateSemestre1")
    private Instant endDateSemestre1;

    @Column(name = "endDateSemestre2")
    private Instant endDateSemestre2;

    /*@OneToMany(mappedBy = "schoolYear")
    private Set<Class> classes;*/



}
