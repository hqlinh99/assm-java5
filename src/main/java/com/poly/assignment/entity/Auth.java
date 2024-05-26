package com.poly.assignment.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @NotBlank(message = "Vui lòng nhập tên tài khoản!")
    private String username;

    @NotBlank(message = "Vui lòng nhập mật khẩu!")
    private String password;

}
