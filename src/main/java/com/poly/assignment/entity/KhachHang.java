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
public class KhachHang {

    private String id;

    @NotBlank(message = "Vui lòng nhập mã khách hàng!")
    private String maKH;

    @NotBlank(message = "Vui lòng nhập tên khách hàng!")
    private String ten;

    @NotBlank(message = "Vui lòng nhập số điện thoại!")
    private String sdt;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    private Boolean trangThai;

}
