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
@Entity(name = "sizes")
public class KichThuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Vui lòng nhập mã kích thước!")
    @Column(name = "ma_kich_thuoc")
    private String maKT;

    @NotBlank(message = "Vui lòng nhập tên kích thước!")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    @Column(name = "trang_thai")
    private Boolean trangThai;

}
