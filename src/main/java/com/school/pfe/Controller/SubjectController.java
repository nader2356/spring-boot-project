package com.school.pfe.Controller;

import com.school.pfe.Dto.SubjectDto;
import com.school.pfe.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.pfe.Utils.Constants.SUBJECT_ENDPOINT;

@RestController
@RequestMapping(value = SUBJECT_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) { this.subjectService = subjectService; }

    @PostMapping(value = "/saveSubject",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectDto> save(@RequestBody SubjectDto subjectDto) {
        SubjectDto subjectDTOsaved = subjectService.save(subjectDto);
        return new ResponseEntity<SubjectDto>(subjectDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteSubject/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        subjectService.delete(id);
    }
    @GetMapping(value = "/getAllSubjects",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubjectDto> findAll() {
        // TODO Auto-generated method stub
        return subjectService.findAll();
    }
    @GetMapping(value = "/getSubject/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SubjectDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return subjectService.findById(id);
    }
    @GetMapping(value = "/getSubjectByName/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SubjectDto findByName(@PathVariable(value = "name") String name) {
        // TODO Auto-generated method stub
        return subjectService.findByName(name);
    }
}
