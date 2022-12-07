package com.school.pfe.Controller;

import com.school.pfe.Dto.SchoolDto;
import com.school.pfe.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.school.pfe.Utils.Constants.SCHOOL_ENDPOINT;

@RestController
@RequestMapping(value = SCHOOL_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")

public class SchoolController {
	@Autowired
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping(value = "/saveSchool",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolDto> save(@RequestBody SchoolDto schoolDto) {
    	SchoolDto schoolDTOsaved = schoolService.save(schoolDto);
        return new ResponseEntity<SchoolDto>(schoolDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteSchool/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
    	schoolService.delete(id);
    }
    @GetMapping(value = "/getAllSchools",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SchoolDto> findAll() {
        // TODO Auto-generated method stub
        return schoolService.findAll();
    }
    @GetMapping(value = "/getSchool/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return schoolService.findById(id);
    }

    @GetMapping(value = "/getSchoolByName/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDto findByCode(@PathVariable(value = "name") String name) {
        // TODO Auto-generated method stub
        return schoolService.findByName(name);
    }

}
