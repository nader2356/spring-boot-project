package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends AbstractEntity{

    private String firsName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String telNum;
    @Embedded
    private Address address;


    @OneToMany(mappedBy = "student")
    private List<Inscription> listInscription;

    @OneToMany(mappedBy="student")
    private List<Absence> listAbsence;

    @ManyToOne
    private Class classe;
    @OneToOne
    private AppUser AppUser;
}
