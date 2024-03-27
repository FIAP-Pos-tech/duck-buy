package br.com.duckstore.duckbuy.config;


import br.com.duckstore.duckbuy.api.auth.AuthClient;
import br.com.duckstore.duckbuy.api.auth.response.TokenValidateResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith(BEARER_PREFIX)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token não encontrado ou inválido.");
            return;
        }

        try {
            String token = header.substring(BEARER_PREFIX.length());
            AuthClient authClient = new AuthClient(token);
            TokenValidateResponse tokenValidateResponse = authClient.validateToken(token);
            if (!tokenValidateResponse.isSuccess()) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalido ou expirado.");
            } else {
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Falha ao validar token.");
        }
    }
}
