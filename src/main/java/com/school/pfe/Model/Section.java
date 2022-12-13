package com.school.pfe.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "section")

public class Section extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    private List<Level> levels;
}
