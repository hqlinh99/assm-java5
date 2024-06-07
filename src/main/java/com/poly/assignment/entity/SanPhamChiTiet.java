package com.poly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_details")
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Vui lòng nhập mã sản phẩm chi tiết!")
    @Column(name = "ma_spct")
    private String maSPCT;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm chi tiết!")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "Vui lòng nhập kích thước")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kich_thuoc")
    private KichThuoc kichThuoc;

    @NotNull(message = "Vui lòng chọn màu sắc!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    @Min(value = 1, message = "Vui lòng nhập số lượng > 0")
    @NotNull(message = "Vui lòng nhập số lượng!")
    @Column(name = "so_luong")
    private Integer soLuong;

    @Min(value = 1, message = "Vui lòng nhập đơn giá > 0")
    @NotNull(message = "Vui lòng nhập đơn giá!")
    @Column(name = "don_gia")
    private Double donGia;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @NotNull(message = "Vui lòng chọn trạng thái")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
