package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Inscription {
    @Id
    @GeneratedValue
    private int id;
    private Date academicYear;
    private int payment;
    private String paymentType;
    private String school;
    private String section;
    private String level;
    private String classe;
    /*@OneToOne
    private Receipt receipt;
    @ManyToOne
    private Student student;*/
}
