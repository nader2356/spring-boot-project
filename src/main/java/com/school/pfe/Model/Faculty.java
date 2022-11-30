package com.school.pfe.Model;

import javax.persistence.OneToMany;
import java.util.List;

public class Faculty {
    @OneToMany(mappedBy = "faculty")
    private List<Level> levels;
}
