package com.poly.assignment.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

    private String id;

    private String hinhAnh;

    @NotBlank(message = "Vui lòng nhập mã nhân viên!")
    private String maNV;

    @NotBlank(message = "Vui lòng nhập tên nhân viên!")
    private String ten;

    @NotBlank(message = "Vui lòng nhập tên đăng nhập!")
    private String tenDangNhap;

    @NotBlank(message = "Vui lòng nhập mật khẩu!")
    private String matKhau;

    @NotNull(message = "Vui lòng chọn chức vụ!")
    private Boolean chucVu;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    private Boolean trangThai;

}
