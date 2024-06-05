package com.poly.assignment.repository;

import com.poly.assignment.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, String> {

    Page<SanPhamChiTiet> findAllBySanPhamIdAndTrangThai(Pageable pageable, String pid, boolean parseBoolean);

    Page<SanPhamChiTiet> findAllBySanPhamId(Pageable pageable, String pid);

    Page<SanPhamChiTiet> findAllByTrangThai(Pageable pageable, boolean status);

    @Query("""
            select e
            from product_details e
            where e.sanPham.id = :pid and (
                  e.maSPCT like %:key% or
                  e.ten like %:key% or
                  e.kichThuoc.ten like %:key% or
                  e.mauSac.ten like %:key% or
                  e.sanPham.maSP like %:key% or
                  e.sanPham.ten like %:key%)
            """)
    List<SanPhamChiTiet> findAllBySanPhamIdAndKey(String pid, String key);

}
