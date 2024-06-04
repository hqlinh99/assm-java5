package com.poly.assignment.repository;

import com.poly.assignment.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}
