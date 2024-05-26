package com.poly.assignment.entity;

import jakarta.validation.constraints.Min;
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
public class SanPhamChiTiet {

    private String id;

    @NotBlank(message = "Vui long nhap ma san pham chi tiet")
    private String maSPCT;

    @NotBlank(message = "Vui long nhap ten san pham chi tiet")
    private String ten;

    @NotNull(message = "Vui long chon kich thuoc")
    private KichThuoc kichThuoc;

    @NotNull(message = "Vui long chon mau sac")
    private MauSac mauSac;

    @NotNull(message = "Vui long chon san pham")
    private SanPham sanPham;

    @Min(value = 1, message = "Vui long nhap so luong > 0")
    @NotNull(message = "Vui long nhap so luong")
    private Integer soLuong;

    @Min(value = 1, message = "Vui long nhap don gia > 0")
    @NotNull(message = "Vui long nhap don gia")
    private Double donGia;

    private String hinhAnh;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
