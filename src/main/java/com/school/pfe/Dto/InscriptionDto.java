package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Absence;
import com.school.pfe.Model.Inscription;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscriptionDto {
    private int id;
    private Date academicYear;
    private int payment;
    private String paymentType;
    private String school;
    private String section;
    private String level;
    private String classe;
    private ReceiptDto receipt;
    private StudentDto student;

    public static InscriptionDto fromEntity(Inscription inscription) {
        if (inscription == null) {
            return null;

        }
        return InscriptionDto.builder()
                .academicYear(inscription.getAcademicYear())
                .payment(inscription.getPayment())
                .paymentType(inscription.getPaymentType())
                .school(inscription.getSchool())
                .section(inscription.getSection())
                //.receipt(ReceiptDto.fromEntity(inscription.getReceipt())
                .id(inscription.getId())
                .level(inscription.getLevel())
                .classe(inscription.getClasse())
                //.student(StudentDto.fromEntity(inscription.getStudent()))



                .build();
    }

    public static Inscription toEntity(InscriptionDto inscriptionDto){
        if(inscriptionDto==null){
            return null;
        }
        Inscription inscription=new Inscription();

        inscription.setId(inscriptionDto.getId());
        inscription.setAcademicYear(inscriptionDto.getAcademicYear());
        inscription.setPayment(inscriptionDto.getPayment());
        inscription.setPaymentType(inscriptionDto.getPaymentType());
        inscription.setSchool(inscriptionDto.getSchool());
        inscription.setSection(inscriptionDto.getSection());
        inscription.setLevel(inscriptionDto.getLevel());
        inscription.setClasse(inscriptionDto.getSchool());

        return inscription;
    }

}

