package com.school.pfe.Controller;

import com.school.pfe.Dto.FacultyDto;
import com.school.pfe.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/school/faculty")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @PostMapping("/addOrUpdate")
    public ResponseEntity<FacultyDto> save(@Valid @RequestBody FacultyDto facultyDto) {
        FacultyDto facultyDTOsaved = facultyService.save(facultyDto);
        return new ResponseEntity<FacultyDto>(facultyDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteFaculty/{id}")
    public void delete(@PathVariable Integer id) {
        // TODO Auto-generated method stub
        facultyService.delete(id);
    }
    @GetMapping("/listerFaculty")
    public List<FacultyDto> liste() {
        // TODO Auto-generated method stub
        return facultyService.findAll();
    }
    @GetMapping("/researchFaculty/{id}")
    public FacultyDto research(@PathVariable Integer id) {
        // TODO Auto-generated method stub
        return facultyService.findById(id);
    }
}
