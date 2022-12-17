package com.school.pfe.Controller;

import com.school.pfe.Dto.ReceiptDto;
import com.school.pfe.Dto.SchoolDto;
import com.school.pfe.Service.ReceiptService;
import com.school.pfe.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.pfe.Utils.Constants.SCHOOL_ENDPOINT;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class ReciptPaymentController {
    private final ReceiptService receiptService;

    public ReciptPaymentController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping(value = "/saveReciptPayment",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceiptDto> save(@RequestBody ReceiptDto receiptDto) {
        ReceiptDto receiptDtosaved = receiptService.save(receiptDto);
        return new ResponseEntity<ReceiptDto>(receiptDtosaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteReciptPaymen/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        receiptService.delete(id);
    }
    @GetMapping(value = "/getAllReciptPaymen",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReceiptDto> findAll() {
        // TODO Auto-generated method stub
        return receiptService.findAll();
    }
    @GetMapping(value = "/getReciptPaymen/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return receiptService.findById(id);
    }

    @GetMapping(value = "/getReciptPaymenByName/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptDto findByCode(@PathVariable(value = "name") String name) {
        // TODO Auto-generated method stub
        return receiptService.findByName(name);
    }

}
