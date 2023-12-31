package com.school.pfe.Controller;

import com.school.pfe.Dto.LabelValueDto;
import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.LevelInfoDto;
import com.school.pfe.Service.LevelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.school.pfe.Utils.Constants.LEVEL_ENDPOINT;

@RestController
@RequestMapping(value = LEVEL_ENDPOINT)
@CrossOrigin(origins = "http://localhost:4200")

public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping(value = "/getAllLevels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LevelInfoDto>> getAllLevels()
    {
        return levelService.getAllLevels();
    }

    @GetMapping(value = "/getLevel/{levelId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LevelDto> getLevelById(@PathVariable(value = "levelId") Long levelId)
    {
        return levelService.getLevelById(levelId);
    }

    @GetMapping(value = "/getLevelByCode/{levelCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LevelDto> getCategoryByCode(@PathVariable(value = "levelCode") String levelCode)
    {
        return levelService.getLevelByCode(levelCode);
    }

    @PostMapping(value = "/saveLevel",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LevelDto> saveLevel(@RequestBody LevelDto levelDto)
    {
        return levelService.saveLevel(levelDto);
    }


    @DeleteMapping("/deleteLevel/{levelId}")
    public ResponseEntity<Void> deleteLevel(@PathVariable(value = "levelId") Long levelId)
    {
        return levelService.deleteLevel(levelId);
    }

    @GetMapping(value = "/getLevelList",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LabelValueDto>> getLevelList()
    {
        return levelService.getLevelList();
    }
}
