package com.school.pfe.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")

public class Subject extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "coefficient")
    private Float coefficient;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

   @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Teacher> teachers;
}
