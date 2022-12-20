package com.school.pfe.Repository;

import com.school.pfe.Model.PaymentReceipt;
import com.school.pfe.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentReceiptRepository extends JpaRepository<PaymentReceipt, Long>{
    Optional<PaymentReceipt> findPaymentReceiptByName(String name);
}
