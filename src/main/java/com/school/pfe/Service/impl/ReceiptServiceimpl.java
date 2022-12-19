package com.school.pfe.Service.impl;

import com.school.pfe.Dto.ConvertSchool;
import com.school.pfe.Dto.ReceiptDto;
import com.school.pfe.Dto.SchoolDto;
import com.school.pfe.Exception.EntityNotFoundException;
import com.school.pfe.Exception.ErrorCodes;
import com.school.pfe.Exception.InvalidOperationException;
import com.school.pfe.Model.PaymentReceipt;
import com.school.pfe.Model.School;
import com.school.pfe.Repository.PaymentReceiptRepository;
import com.school.pfe.Service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ReceiptServiceimpl implements ReceiptService{
	private final PaymentReceiptRepository repository;
	@Override
	public ReceiptDto save(ReceiptDto receiptDto) {
		
			PaymentReceipt inscription = ReceiptDto.toEntity(receiptDto);
			PaymentReceipt inscriptionsaved=repository.save(inscription);
			ReceiptDto receiptDtosav= ReceiptDto.fromEntity(inscriptionsaved);

	        return receiptDtosav;
	}

	@Override
	public ReceiptDto findById(Long id) {
		  return repository.findById(id)
	                .map(ReceiptDto::fromEntity)
	                .orElseThrow();
	}

	@Override
	public List<ReceiptDto> findAll() {
		    return repository.findAll()
		        .stream()
		        .map(ReceiptDto::fromEntity)
		        .collect(Collectors.toList());
		  
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}


	@Override
	public ReceiptDto findByName(String name) {

		if (!StringUtils.hasLength(name)) {
			throw new InvalidOperationException("Impossible de trouver une receipt avec un Nom NULL", ErrorCodes.SCHOOL_NAME_IS_NULL);
		}
		Optional<PaymentReceipt> paymentReceipt = repository.findPaymentReceiptByName(name);

		return Optional.of(ReceiptDto.fromEntity(PaymentReceipt.builder().build())).orElseThrow(() ->
				new EntityNotFoundException(
						"Aucune receipt avec le nom = " + name + " n'a été trouvée dans la BDD",
						ErrorCodes.SCHOOL_NOT_FOUND)
		);

	}

}
