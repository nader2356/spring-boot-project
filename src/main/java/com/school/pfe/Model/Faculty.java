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
@Table(name = "faculty")

public class Faculty extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    private List<Level> levels;

}
