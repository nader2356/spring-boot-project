package com.school.pfe.Service.impl;

import com.school.pfe.Dto.LevelDto;
import com.school.pfe.Dto.LevelInfoListingDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Level;
import com.school.pfe.Repository.LevelRepository;
import com.school.pfe.Service.LevelService;
import com.school.pfe.Validation.LevelValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import com.school.pfe.Exception.InvalidEntityException;
@Service
@Slf4j
public class LevelServiceImpl implements LevelService {

    private LevelRepository levelRepository;
    //private ClassRepository classRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public ResponseEntity<List<LevelInfoListingDto>> getAllLevels() {

        return   ResponseEntity.ok(levelRepository.findAll().stream().map(LevelInfoListingDto::fromEntity).collect(Collectors.toList()));

    }

    @Override
    public ResponseEntity<LevelDto> getLevelById(Long levelId) {

        if(levelId == null)
        {
            log.error("Category ID is NULL ");
            throw new InvalidOperationException("Impossible de trouver un niveau avec un ID NULL", ErrorCodes.LEVEL_ID_IS_NULL);
        }

        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun niveau avec l'ID :: " + levelId + "n'a été trouvé" , ErrorCodes.LEVEL_NOT_FOUND));

        return ResponseEntity.ok(LevelDto.fromEntity(level));

    }

    @Override
    public ResponseEntity<LevelDto> getLevelByCode(String levelCode) {

        if(!StringUtils.hasLength(levelCode))
        {
            log.error("Level CODE is NULL ");
            throw new InvalidOperationException("Impossible de trouver un niveau avec un CODE NULL",ErrorCodes.LEVEL_CODE_IS_NULL);
        }

        Level level = levelRepository.findLevelByCode(levelCode)
                .orElseThrow(() -> new EntityNotFoundException("Aucun niveau avec le CODE :: " + levelCode + "n'a été trouvée" , ErrorCodes.LEVEL_NOT_FOUND));

        return ResponseEntity.ok(LevelDto.fromEntity(level));

    }

    @Override
    public ResponseEntity<LevelDto> saveLevel(LevelDto levelDto) {

        List<String> errors = LevelValidation.validate(levelDto);

        if(!errors.isEmpty())
        {
            log.error("Level is not valid {}" , levelDto);
            throw new InvalidEntityException("le niveau  n'est pas valide" , ErrorCodes.LEVEL_NOT_VALID,errors);
        }

        Level level = LevelDto.toEntity(levelDto);
        Level levelSaved = levelRepository.save(level);

        return ResponseEntity.ok(LevelDto.fromEntity(levelSaved));

    }

    @Override
    public ResponseEntity<Void> deleteLevel(Long levelId) {

        if(levelId == null)
        {
            log.error("Level ID is NULL ");
            throw new InvalidOperationException("Impossible de supprimer un niveau  avec un ID NULL",ErrorCodes.LEVEL_ID_IS_NULL);

        }

        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun niveau avec l'ID :: " + levelId + "n'a été trouvée" ,ErrorCodes.LEVEL_NOT_FOUND));

        /*List<Class> classList = classRepository.findAllByLevelId(level);
        if(!classList.isEmpty())
        {
            throw new InvalidOperationException("Impossible de supprimer un niveau deja utilisée dans des classes",ErrorCodes.LEVEL_ALREADY_IN_USE);
        }*/
        levelRepository.delete(level);
        return ResponseEntity.ok().build();

    }
}
