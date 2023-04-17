package com.app.foodverse.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/admin/");
        }
        else if (roles.contains("ROLE_RESTAURANT")) {
            response.sendRedirect("/restaurant/");
        }
        else if (roles.contains("ROLE_REQUESTED")) {
            response.sendRedirect("/request/");
        }
        else {
            response.sendRedirect("/customer/");
        }
    }
}
