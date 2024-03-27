package br.com.duckstore.duckbuy.api.auth;

import br.com.duckstore.duckbuy.api.auth.interceptor.BearerInterceptor;
import br.com.duckstore.duckbuy.api.auth.response.CustomerResponse;
import br.com.duckstore.duckbuy.api.auth.response.TokenValidateResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class AuthClient {

    private final String token;

    public AuthClient(String token) {
        this.token = token;
    }

    public AuthApi getClient(String token) {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .requestInterceptor(new BearerInterceptor(token))
                .target(AuthApi.class, "http://localhost:8080");
    }

    public TokenValidateResponse validateToken(String token) {
        return getClient(token).validateToken();
    }

    public CustomerResponse getCustomer() {
        return getClient(token).getCustomer();
    }

}
