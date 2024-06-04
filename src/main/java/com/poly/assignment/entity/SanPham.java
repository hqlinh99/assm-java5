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
@Entity(name = "products")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Vui lòng nhập mã sản phẩm!")
    @Column(name = "ma_san_pham")
    private String maSP;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm!")
    @Column(name = "ten")
    private String ten;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
