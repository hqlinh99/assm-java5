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
@Entity(name = "customers")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Vui lòng nhập mã khách hàng!")
    @Column(name = "ma_khach_hang")
    private String maKH;

    @NotBlank(message = "Vui lòng nhập tên khách hàng!")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Vui lòng nhập số điện thoại!")
    @Column(name = "sdt")
    private String sdt;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
