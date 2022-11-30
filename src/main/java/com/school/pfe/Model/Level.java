package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "level")
public class Level extends AbstractEntity{
    private String label ;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

}
