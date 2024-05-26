package com.poly.assignment.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {

    private String id;

    @NotNull(message = "Vui long chon nhan vien")
    private NhanVien nhanVien;

    @NotNull(message = "Vui long chon khach hang")
    private KhachHang khachHang;

    private Date ngayMuaHang = new Date();

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
