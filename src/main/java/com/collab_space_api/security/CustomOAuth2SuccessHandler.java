package com.collab_space_api.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final Environment environment;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        if (oAuth2User == null) {
            throw new AuthenticationException("Usuário OAuth2 não encontrado");
        }

        String email = oAuth2User.getAttribute("email");
        if (email == null || email.trim().isEmpty()) {
            throw new AuthenticationException("Email não encontrado nas informações do usuário");
        }

        String token = jwtTokenProvider.generateToken(email);

        // Usar uma URL configurável
        String redirectUrl = environment.getProperty("oauth.success.redirect.url");
        // Considerar usar um metodo mais seguro para transmitir o token
        response.addHeader("Authorization", "Bearer " + token);
        response.sendRedirect(redirectUrl);
    }

}
