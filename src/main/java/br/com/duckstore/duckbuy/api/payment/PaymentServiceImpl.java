package br.com.duckstore.duckbuy.api.payment;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.payments.Payment;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class PaymentServiceImpl implements PaymentService{



    public PaymentService getPaymentById() {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        return Feign.builder()
                .decoder(new JacksonDecoder(objectMapper))
                .encoder(new JacksonEncoder())
                .target(PaymentService.class, "http://localhost:8040");
    }

    @Override
    public Payment getPaymentDetails(String paymentId) {
        return getPaymentById().getPaymentDetails(paymentId);
    }
}
