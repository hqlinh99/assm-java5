package com.poly.assignment.repository;

import com.poly.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {

    Optional<NhanVien> findByTenDangNhap(String username);

    Page<NhanVien> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from employees e where e.ma_nhan_vien like %:key% or e.ten like %:key%", nativeQuery = true)
    List<NhanVien> findAllByKey(String key);

}
