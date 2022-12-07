package com.school.pfe.Controller;

import static com.school.pfe.Utils.Constants.SALLE_ENDPOINT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.pfe.Dto.SalleDTO;
import com.school.pfe.Service.SalleService;

@RestController
@RequestMapping(value = SALLE_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class SalleController {
	@Autowired
    private SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }


    @PostMapping(value = "/saveSalle",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalleDTO> save(@RequestBody SalleDTO salleDTO) {
    	SalleDTO salleDTOsaved = salleService.save(salleDTO);
        return new ResponseEntity<SalleDTO>(salleDTOsaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteSalle/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
    	salleService.delete(id);
    }
    @GetMapping(value = "/getAllSalles",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SalleDTO> findAll() {
        // TODO Auto-generated method stub
        return salleService.findAll();
    }
    @GetMapping(value = "/getSalle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SalleDTO findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return salleService.findById(id);
    }

   
}
