package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.school.pfe.Dto.ClassRoomDto;

import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.ClassRoom;
import com.school.pfe.Repository.ClassRoomRepository;
import com.school.pfe.Service.ClassRoomService;
import com.school.pfe.Validation.ClassRoomValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomRepository classRoomRepository;

    public ClassRoomServiceImpl (ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public ClassRoomDto save(ClassRoomDto classRoomDto) {

        List<String> errors = ClassRoomValidator.validate(classRoomDto);

        if (!errors.isEmpty()) {
            log.error("salle is not valid {}", classRoomDto);
            throw new InvalidEntityException("La salle n'est pas valide", ErrorCodes.CLASSROOM_ENDPOINT_NOT_VALID, errors);
        }
        return ClassRoomDto.fromEntity(
        		classRoomRepository.save(
        				classRoomDto.toEntity(classRoomDto)
                )
        );

    }

    @Override
    public ClassRoomDto findById(Long id) {

        if (id == null) {
            log.error("Salle ID is null");
            throw new InvalidOperationException("Impossible de trouver une salle avec un ID NULL", ErrorCodes.CLASSROOM_ENDPOINT_ID_IS_NULL);
        }
        Optional<ClassRoom> classRoomDto = classRoomRepository.findById(id);

        return Optional.of(ClassRoomDto.fromEntity(classRoomDto.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune salle avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.CLASSROOM_ENDPOINT_NOT_FOUND)
        );
        

    }

    @Override
    public List<ClassRoomDto> findAll() {

        return classRoomRepository.findAll().stream()
                .map(ClassRoomDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            log.error("classRoom id is null");
            throw new InvalidOperationException("Impossible de supprimer une salle  avec un ID NULL",ErrorCodes.CLASSROOM_ENDPOINT_ID_IS_NULL);
        }
        classRoomRepository.deleteById(id);

    }}

	


