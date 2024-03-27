package br.com.duckstore.duckbuy.api.payment;

import com.paypal.api.payments.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/{paymentId}")
    public Payment getPaymentDetails(@PathVariable String paymentId) {
        return paymentService.getPaymentDetails(paymentId);
    }
}
