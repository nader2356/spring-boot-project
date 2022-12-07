package com.school.pfe.Controller;

import com.school.pfe.Dto.ClassDto;
import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.SchoolYearDto;
import com.school.pfe.Service.ClassService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.pfe.Utils.Constants.CLASS_ENDPOINT;

@RestController
@RequestMapping(value = CLASS_ENDPOINT)
public class ClassController{

    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClassDto>> findAll()
    {
        return classService.findAll();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassDto> findById(@PathVariable(value = "id") Long id)
    {
        return classService.findById(id);
    }

    @GetMapping(value = "/findAllBySchoolYear",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClassDto>> findAllBySchoolYear(@RequestBody SchoolYearDto dto) {
        return classService.findAllBySchoolYear(dto);
    }

    @GetMapping(value = "/findAllByLevel",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClassDto>> findAllByLevel(@RequestBody LevelDto dto) {
        return classService.findAllByLevel(dto);


    }
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassDto> save(@RequestBody ClassDto dto)
    {
        return classService.save(dto);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id)
    {
        return classService.deleteById(id);
    }
}