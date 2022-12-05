package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "level")

public class Level extends AbstractEntity{

    private String code ;

    private String label ;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "level")
    private List<Class> classes;

}
