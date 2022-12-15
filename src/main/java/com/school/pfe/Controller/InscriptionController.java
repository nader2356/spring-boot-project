package com.school.pfe.Controller;

import com.school.pfe.Dto.AbsenceDto;
import com.school.pfe.Dto.InscriptionDto;
import com.school.pfe.Service.AbsenceService;
import com.school.pfe.Service.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping("/addOrUpdate")
    public ResponseEntity<InscriptionDto> save(@Valid @RequestBody InscriptionDto inscriptionDto) {
        InscriptionDto inscriptionDTOsaved = InscriptionService.save(inscriptionDto);
        return new ResponseEntity<InscriptionDto>(inscriptionDTOsaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteInscription/{id}")
    public void delete(@PathVariable Long id) {

        inscriptionService.delete(id);
    }

    @GetMapping("/listeInscription")
    public List<InscriptionDto> liste() {

        return inscriptionService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public InscriptionDto getbyid(@PathVariable Long id) {

        return inscriptionService.findbyId(id);
    }

}
