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

    @Query(value = """
            select e from invoices e 
            where e.id like %:key% 
            or e.khachHang.ten like %:key%
            or e.nhanVien.ten like %:key%
            """)
    List<HoaDon> findAllByKey(String key);
}
