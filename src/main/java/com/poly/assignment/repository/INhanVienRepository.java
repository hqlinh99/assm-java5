package com.poly.assignment.repository;

import com.poly.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {

    Page<NhanVien> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from employees e where e.ma_nhan_vien like %:key% or e.ten like %:key%", nativeQuery = true)
    List<NhanVien> findAllByKey(String key);

}
