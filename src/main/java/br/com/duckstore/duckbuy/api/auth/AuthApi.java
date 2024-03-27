package br.com.duckstore.duckbuy.api.auth;

import br.com.duckstore.duckbuy.api.auth.response.CustomerResponse;
import br.com.duckstore.duckbuy.api.auth.response.TokenValidateResponse;
import feign.Headers;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface AuthApi {

    @RequestLine("GET /api/auth/token/validate")
    TokenValidateResponse validateToken();

    @RequestLine("GET /api/auth/token/customer")
    CustomerResponse getCustomer();


}
