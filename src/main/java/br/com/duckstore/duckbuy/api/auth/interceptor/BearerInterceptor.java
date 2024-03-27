package br.com.duckstore.duckbuy.api.auth.interceptor;

import feign.RequestTemplate;

public class BearerInterceptor implements feign.RequestInterceptor {

    private final String token;

    public BearerInterceptor(String token) {
        this.token = token;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
