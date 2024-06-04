package com.poly.assignment.entity;

import jakarta.persistence.*;
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
@Entity(name = "employees")
public class NhanVien implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @NotBlank(message = "Vui lòng nhập mã nhân viên!")
    @Column(name = "ma_nhan_vien")
    private String maNV;

    @NotBlank(message = "Vui lòng nhập tên nhân viên!")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Vui lòng nhập tên đăng nhập!")
    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;

    @NotBlank(message = "Vui lòng nhập mật khẩu!")
    @Column(name = "mat_khau")
    private String matKhau;

    @NotNull(message = "Vui lòng chọn chức vụ!")
    @Column(name = "chuc_vu")
    private Boolean chucVu;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    private Boolean trangThai;

    @Override
    public NhanVien clone() {
        try {
            NhanVien clone = (NhanVien) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
