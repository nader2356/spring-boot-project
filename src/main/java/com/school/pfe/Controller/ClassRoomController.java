package com.school.pfe.Controller;

import static com.school.pfe.Utils.Constants.CLASSROOM_ENDPOINT;

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

import com.school.pfe.Dto.ClassRoomDto;

import com.school.pfe.Service.ClassRoomService;

@RestController
@RequestMapping(value = CLASSROOM_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")
public class ClassRoomController {
	@Autowired
    private ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }


    @PostMapping(value = "/saveClassRoom",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassRoomDto> save(@RequestBody ClassRoomDto classRoomDto) {
    	ClassRoomDto classRoomDtosaved = classRoomService.save(classRoomDto);
        return new ResponseEntity<ClassRoomDto>(classRoomDtosaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteClassRoom/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
    	classRoomService.delete(id);
    }
    @GetMapping(value = "/getAllClassRooms",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClassRoomDto> findAll() {
        // TODO Auto-generated method stub
        return classRoomService.findAll();
    }
    @GetMapping(value = "/getClassRoom/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ClassRoomDto findById(@PathVariable(value = "id") Long id) {
        // TODO Auto-generated method stub
        return classRoomService.findById(id);
    }

   
}
