package com.school.pfe.Service;

import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.LevelInfoListingDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelService {

    ResponseEntity<List<LevelInfoListingDto>> getAllLevels();

    ResponseEntity<LevelDto> getLevelById(Long levelId);

    ResponseEntity<LevelDto> getLevelByCode(String levelCode);

    ResponseEntity<LevelDto> saveLevel(LevelDto levelDto);

    ResponseEntity<Void> deleteLevel(Long levelId) ;

}
