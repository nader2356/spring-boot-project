package com.school.pfe.Dto;

import java.math.BigDecimal;
import java.util.Date;

import com.school.pfe.Model.PaymentReceipt;
import com.school.pfe.Model.SchoolYear;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReceiptDto {
	private Long id;
	private BigDecimal price;
	private Date dateReceipt;
	
	
	
	 public static ReceiptDto fromEntity(PaymentReceipt entity) {
	        if (entity == null) {
	            return null;
	        }

	        return ReceiptDto.builder()
	                .id(entity.getId())
	                .price(entity.getPrice())
	                .dateReceipt(entity.getDateReceipt())
	                
	                .build();
	    }
	    public static PaymentReceipt toEntity(ReceiptDto receiptDto) {
	        if (receiptDto == null) {
	            return null;
	        }
	        return PaymentReceipt.builder()
	                .id(receiptDto.getId())
	                .price(receiptDto.getPrice())
	                .dateReceipt(receiptDto.getDateReceipt())
	                .build();
	    }
	
	
}
