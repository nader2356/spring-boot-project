package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
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
    private Level level  ;

   /* @OneToOne
    private TimeTable TimeTable;
*/

    @OneToMany(mappedBy="classe",fetch=FetchType.EAGER)
    private List<Student> students;


}
