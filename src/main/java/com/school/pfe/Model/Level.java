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
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "level")
    private List<Class> classes;

    @OneToMany(mappedBy = "level")
    private List<Subject> subjects;

}
