package com.school.pfe.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.school.pfe.Dto.SalleDTO;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidEntityException;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.Salle;
import com.school.pfe.Repository.SalleRepository;
import com.school.pfe.Service.SalleService;
import com.school.pfe.Validation.SalleValidator;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SalleServiceImpl implements SalleService {

    private SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public SalleDTO save(SalleDTO salleDTO) {

        List<String> errors = SalleValidator.validate(salleDTO);

        if (!errors.isEmpty()) {
            log.error("faculty is not valid {}", salleDTO);
            throw new InvalidEntityException("La salle n'est pas valide", ErrorCodes.SALLE_NOT_VALID, errors);
        }
        return SalleDTO.fromEntity(
        		salleRepository.save(
        				salleDTO.toEntity(salleDTO)
                )
        );

    }

    @Override
    public SalleDTO findById(Long id) {

        if (id == null) {
            log.error("Salle ID is null");
            throw new InvalidOperationException("Impossible de trouver une salle avec un ID NULL", ErrorCodes.SALLE_ID_IS_NULL);
        }
        Optional<Salle> salle = salleRepository.findById(id);

        return Optional.of(SalleDTO.fromEntity(salle.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune salle avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCodes.SALLE_NOT_FOUND)
        );
        

    }

    @Override
    public List<SalleDTO> findAll() {

        return salleRepository.findAll().stream()
                .map(SalleDTO::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            log.error("Salle id is null");
            throw new InvalidOperationException("Impossible de supprimer une salle  avec un ID NULL",ErrorCodes.SALLE_ID_IS_NULL);
        }
        salleRepository.deleteById(id);

    }}

	


