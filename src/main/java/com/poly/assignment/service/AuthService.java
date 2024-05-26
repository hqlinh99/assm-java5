package com.poly.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.NhanVien;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final NhanVienService nhanVienService;

    private final ObjectMapper objectMapper;

    private final HttpServletResponse httpServletResponse;

    private final HttpServletRequest httpServletRequest;

    public String login(Auth auth) throws JsonProcessingException {
        NhanVien nhanVien = nhanVienService.findByUsername(auth.getUsername());


        if (nhanVien != null) {
            if (!nhanVien.getTrangThai()) return "Tài khoản đã bị vô hiệu hoá!";

            if (nhanVien.getTenDangNhap().equals(auth.getUsername()) && nhanVien.getMatKhau().equals(auth.getPassword())) {
                saveCurrentUser(nhanVien.clone());
                return null;
            }
        }

        return "Sai tên mật khẩu hoặc tài khoản";
    }

    public NhanVien getCurrentUser() {
        try {

            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("currentUser")) {
                        return objectMapper.readValue(Base64.decodeBase64(cookie.getValue()), NhanVien.class);
                    }
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public void logout() {
        Cookie cookie = new Cookie("currentUser", null);
        httpServletResponse.addCookie(cookie);
    }

    private void saveCurrentUser(NhanVien nhanVien) throws JsonProcessingException {
        nhanVien.setMatKhau(null);

        String base64 = Base64.encodeBase64String(objectMapper.writeValueAsBytes(nhanVien));

        Cookie cookie = new Cookie("currentUser", base64);

        httpServletResponse.addCookie(cookie);
    }

}
