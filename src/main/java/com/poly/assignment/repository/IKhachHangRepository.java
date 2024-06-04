package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKhachHangRepository extends JpaRepository<KhachHang, String> {
}
