package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "class")
public class Class  extends AbstractEntity
{
    @NotNull(message = "nameClass is required")
    @Column(name = "nameClass")
    private  String nameClass;

    @NotNull(message = "labelClass is required")
    @Column(name = "labelClass")
    private  String labelClass;

    @ManyToOne
    private SchoolYear schoolYear;


    @ManyToOne
    private Level level;

    @OneToOne
    private Planning planning;

}
