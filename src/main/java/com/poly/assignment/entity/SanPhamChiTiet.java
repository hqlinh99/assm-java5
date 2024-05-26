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

    @NotBlank(message = "Vui lòng nhập mã sản phẩm chi tiết!")
    private String maSPCT;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm chi tiết!")
    private String ten;

    @NotNull(message = "Vui lòng nhập kích thước")
    private KichThuoc kichThuoc;

    @NotNull(message = "Vui lòng chọn màu sắc!")
    private MauSac mauSac;

    private SanPham sanPham;

    @Min(value = 1, message = "Vui lòng nhập số lượng > 0")
    @NotNull(message = "Vui lòng nhập số lượng")
    private Integer soLuong;

    @Min(value = 1, message = "Vui lòng nhập đơn giá > 0")
    @NotNull(message = "Vui lòng nhập đơn giá")
    private Double donGia;

    private String hinhAnh;

    @NotNull(message = "Vui lòng chọn trạng thái")
    private Boolean trangThai;

}
