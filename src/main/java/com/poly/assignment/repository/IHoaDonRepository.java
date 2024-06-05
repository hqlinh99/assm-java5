package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoaDonRepository extends JpaRepository<HoaDon, String> {
    Page<HoaDon> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from orders e where e.ma_san_pham like %:key% or p.ten like %:key%", nativeQuery = true)
    List<HoaDon> findAllByKey(String key);
}
