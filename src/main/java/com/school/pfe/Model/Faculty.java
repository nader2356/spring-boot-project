<<<<<<< HEAD
package com.school.pfe.Model;

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
public class Faculty extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "faculty")
    private List<Level> levels;
}
=======
package com.school.pfe.Model;

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
public class Faculty extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "faculty")
    private List<Level> levels;
}
>>>>>>> b6c7a0cf88ae0d82b498a7cb37a048190bafef2e
