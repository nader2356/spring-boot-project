package com.school.pfe.Controller;

import com.school.pfe.Dto.AbsenceDto;
import com.school.pfe.Service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/school/absence")
@CrossOrigin(origins = "http://localhost:4200")
public class AbsenceController {
    private AbsenceService absenceService;
    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<AbsenceDto> save(@Valid @RequestBody AbsenceDto absenceDto) {
        AbsenceDto absenceDTOsaved = absenceService.save(absenceDto);
        return new ResponseEntity<AbsenceDto>(absenceDTOsaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAbsence/{id}")
    public void delete(@PathVariable Integer id) {

        absenceService.delete(id);
    }

    @GetMapping("/listeAbsence")
    public List<AbsenceDto> liste() {

        return absenceService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public AbsenceDto getbyid(@PathVariable Integer id) {

        return absenceService.findbyId(id);
    }

}
