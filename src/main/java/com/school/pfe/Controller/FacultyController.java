package com.school.pfe.Controller;

import com.school.pfe.Dto.FacultyDto;
import com.school.pfe.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.school.pfe.Utils.Constants.FACULTY_ENDPOINT;

@RestController
@RequestMapping(value = FACULTY_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping(value = "/saveFaculty",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacultyDto> save(@RequestBody FacultyDto facultyDto) {
        FacultyDto facultyDTOsaved = facultyService.save(facultyDto);
        return new ResponseEntity<FacultyDto>(facultyDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteFaculty/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        facultyService.delete(id);
    }
    @GetMapping(value = "/getAllFaculties",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FacultyDto> findAll() {
        // TODO Auto-generated method stub
        return facultyService.findAll();
    }
    @GetMapping(value = "/getFaculty/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FacultyDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return facultyService.findById(id);
    }

    @GetMapping(value = "/getFacultyByCode/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FacultyDto findByCode(@PathVariable(value = "code") String code) {
        // TODO Auto-generated method stub
        return facultyService.findByCode(code);
    }
}
