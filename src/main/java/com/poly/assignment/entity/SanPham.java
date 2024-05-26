package com.poly.assignment.entity;

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
public class SanPham {

    private String id;

    @NotBlank(message = "Vui lòng nhập mã sản phẩm!")
    private String maSP;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm!")
    private String ten;

    private String hinhAnh;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    private Boolean trangThai;

}
