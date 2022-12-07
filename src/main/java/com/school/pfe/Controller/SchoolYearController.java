package com.school.pfe.Controller;


import com.school.pfe.Dto.SchoolYearDto;
import com.school.pfe.Service.SchoolYearService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.pfe.Utils.Constants.SCHOOL_YEAR_ENDPOINT;

@RestController
@RequestMapping(value = SCHOOL_YEAR_ENDPOINT)
public class SchoolYearController {

    private SchoolYearService schoolYearService;

    public SchoolYearController(SchoolYearService schoolYearService) {
        this.schoolYearService = schoolYearService;
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolYearDto>> findAll()
    {
        return schoolYearService.findAll();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolYearDto> findById(@PathVariable(value = "id") Long id)
    {
        return schoolYearService.findById(id);
    }

    @GetMapping(value = "/findSchoolYearByYear/{year}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolYearDto> findSchoolYearByYear(@PathVariable(value = "year") String year)
    {
        return schoolYearService.findSchoolYearByYear(year);
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolYearDto> save(@RequestBody SchoolYearDto dto)
    {
        return schoolYearService.save(dto);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id)
    {
        return schoolYearService.deleteById(id);
    }
}