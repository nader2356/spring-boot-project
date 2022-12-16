package com.school.pfe.Service.impl;

import com.school.pfe.Dto.InscriptionDto;
import com.school.pfe.Dto.TeacherDto;
import com.school.pfe.Model.Inscription;
import com.school.pfe.Repository.InscriptionRepository;
import com.school.pfe.Service.InscriptionService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository repository;

    @Override
    public InscriptionDto save(InscriptionDto dto) {
        Inscription inscription = InscriptionDto.toEntity(dto);
        Inscription inscriptionsaved=repository.save(inscription);
        InscriptionDto inscriptionDto= InscriptionDto.fromEntity(inscriptionsaved);

        return inscriptionDto;

    }

    @Override
    public InscriptionDto findbyId(Long id) {
        return repository.findById(id)
                .map(InscriptionDto::fromEntity)
                .orElseThrow();
    }

    @Override
    public List<InscriptionDto> findAll() {
            return repository.findAll()
                    .stream()
                    .map(InscriptionDto::fromEntity)
                    .collect(Collectors.toList());
        }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
