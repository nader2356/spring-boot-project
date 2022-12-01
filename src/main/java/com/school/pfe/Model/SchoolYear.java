package com.school.pfe.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "schoolYear")
public class SchoolYear extends AbstractEntity{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "Africa/Tunis")
    @Column(name = "year")
    private Date year;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    @Column(name = "startDateSemestre1")
    private Date startDateSemestre1;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    @Column(name = "startDateSemestre2")
    private Date startDateSemestre2;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    @Column(name = "endDateSemestre1")
    private Date endDateSemestre1;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Africa/Tunis")
    @Column(name = "endDateSemestre2")
    private Date endDateSemestre2;

    @OneToMany(mappedBy = "schoolYear")
    private Set<Class> classes;



}
