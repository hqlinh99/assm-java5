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

    @NotBlank(message = "Vui lòng nhập mã kích thước!")
    private String maKT;

    @NotBlank(message = "Vui lòng nhập tên kích thước!")
    private String ten;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    private Boolean trangThai;

}
