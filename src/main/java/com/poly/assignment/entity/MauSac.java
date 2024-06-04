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
@Entity(name = "colors")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Vui lòng nhập mã màu sắc!")
    @Column(name = "ma_mau_sac")
    private String maMS;

    @NotBlank(message = "Vui lòng nhập tên màu sắc!")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
