package com.school.pfe.Service;

import com.school.pfe.Dto.LabelValueDto;
import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.LevelInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelService {

    ResponseEntity<List<LevelInfoDto>> getAllLevels();

    ResponseEntity<LevelDto> getLevelById(Long levelId);

    ResponseEntity<LevelDto> getLevelByCode(String levelCode);

    ResponseEntity<LevelDto> saveLevel(LevelDto levelDto);

    ResponseEntity<Void> deleteLevel(Long levelId) ;

    ResponseEntity<List<LabelValueDto>> getLevelList();

}
