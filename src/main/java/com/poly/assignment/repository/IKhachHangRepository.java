package com.poly.assignment.repository;

import com.poly.assignment.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IKhachHangRepository extends JpaRepository<KhachHang, String> {

    Page<KhachHang> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from customers e where e.ma_khach_hang like %:key% or e.ten like %:key% or e.sdt like %:key%", nativeQuery = true)
    List<KhachHang> findAllByKey(String key);

}
