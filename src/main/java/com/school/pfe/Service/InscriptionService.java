package com.school.pfe.Service;

import com.school.pfe.Dto.InscriptionDto;

import java.util.List;

public interface InscriptionService {
    static InscriptionDto save(InscriptionDto dto);
    InscriptionDto findbyId(Long id);
    List<InscriptionDto> findAll();
    void delete(Long id);
}
