package com.school.pfe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class PaymentReceipt extends AbstractEntity{
	
	private BigDecimal price;
	private Date dateReceipt;
	private String name;
	//@OneToOne
	//private Inscription inscription;


	

}
