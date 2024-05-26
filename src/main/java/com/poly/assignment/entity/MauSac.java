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
public class MauSac {

    private String id;

    @NotBlank(message = "Vui long nhap ma mau sac")
    private String maMS;

    @NotBlank(message = "Vui long nhap ten mau sac")
    private String ten;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
