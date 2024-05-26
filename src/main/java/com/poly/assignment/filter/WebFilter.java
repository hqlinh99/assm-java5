package com.poly.assignment.filter;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.service.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WebFilter implements Filter {

    private final AuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        HttpServletResponse httpServletResponse = ((HttpServletResponse) response);

        if (checkUri(httpServletRequest.getRequestURI())) {
            NhanVien nhanVien = authService.getCurrentUser();

            if (nhanVien != null) {
                request.setAttribute("currentUser", nhanVien);
            } else {
                httpServletResponse.sendRedirect("/login");
            }
        }
        chain.doFilter(request, response);
    }

    private boolean checkUri(String uri) {
        List<String> listUri = Arrays.asList(
                "/login",
                "/logout",
                "/public");

        for (String item : listUri) {
            if (uri.startsWith(item)) return false;
        }

        return true;
    }

}
