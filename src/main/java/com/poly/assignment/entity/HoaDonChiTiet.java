package com.poly.assignment.entity;

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
public class HoaDonChiTiet {

    private String id;

    @NotNull(message = "Vui long chon hoa don")
    private HoaDon hoaDon;

    @NotNull(message = "Vui long chon san pham chi tiet")
    private SanPhamChiTiet sanPhamChiTiet;

    @NotNull(message = "Vui long nhap so luong")
    private Integer soLuong;

    @NotNull(message = "Vui long nhap don gia")
    private Double donGia;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
