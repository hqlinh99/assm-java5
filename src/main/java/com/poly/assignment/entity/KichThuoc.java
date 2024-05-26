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
public class KichThuoc {

    private String id;

    @NotBlank(message = "Vui long nhap ma kich thuoc")
    private String maKT;

    @NotBlank(message = "Vui long nhap ten kich thuoc")
    private String ten;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
