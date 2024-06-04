package com.poly.assignment.entity;

import jakarta.persistence.*;
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
@Entity(name = "invoice_details")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull(message = "Vui long chon hoa don")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @NotNull(message = "Vui long chon san pham chi tiet")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_spct")
    private SanPhamChiTiet sanPhamChiTiet;

    @NotNull(message = "Vui long nhap so luong")
    @Column(name = "so_luong")
    private Integer soLuong;

    @NotNull(message = "Vui long nhap don gia")
    @Column(name = "don_gia")
    private Double donGia;

    @NotNull(message = "Vui long chon trang thai")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
