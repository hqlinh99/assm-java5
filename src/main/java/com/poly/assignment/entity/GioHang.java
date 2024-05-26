package com.poly.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHang {

    private String id;

    private SanPhamChiTiet sanPhamChiTiet;

    private int quantity;

}
