package br.com.duckstore.duckbuy.api.payment;

import com.paypal.api.payments.Payment;
import feign.RequestLine;
import org.springframework.data.repository.query.Param;

public interface PaymentService {
    @RequestLine("GET /payments/{paymentId}")
    Payment  getPaymentDetails(@Param("paymentId") String paymentId);
}
