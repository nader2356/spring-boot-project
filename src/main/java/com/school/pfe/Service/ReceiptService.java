package com.school.pfe.Service;

import com.school.pfe.Dto.ReceiptDto;
import com.school.pfe.Dto.SchoolDto;

import java.util.List;

public interface ReceiptService {
	
	ReceiptDto save(ReceiptDto receiptDto);

	ReceiptDto findById(Long id);

    List<ReceiptDto> findAll();

    void delete(Long id);

    ReceiptDto findByName(String name);
}
