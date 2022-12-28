package com.school.pfe.Controller;

import com.school.pfe.Dto.LabelValueDto;
import com.school.pfe.Dto.SectionDto;
import com.school.pfe.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.pfe.Utils.Constants.SECTION_ENDPOINT;

@RestController
@RequestMapping(value = SECTION_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    public SectionController(SectionService sectionService) { this.sectionService = sectionService; }

    @PostMapping(value = "/saveSection",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDto> save(@RequestBody SectionDto sectionDto) {
        SectionDto sectionDTOsaved = sectionService.save(sectionDto);
        return new ResponseEntity<SectionDto>(sectionDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteSection/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        sectionService.delete(id);
    }
    @GetMapping(value = "/getAllSections",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectionDto> findAll() {
        // TODO Auto-generated method stub
        return sectionService.findAll();
    }
    @GetMapping(value = "/getSection/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SectionDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return sectionService.findById(id);
    }
    @GetMapping(value = "/getSectionByCode/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SectionDto findByCode(@PathVariable(value = "code") String code) {
        // TODO Auto-generated method stub
        return sectionService.findByCode(code);
    }

    @GetMapping(value = "/getSections",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LabelValueDto> getSections() {
        // TODO Auto-generated method stub
        return sectionService.getSections();
    }
}
