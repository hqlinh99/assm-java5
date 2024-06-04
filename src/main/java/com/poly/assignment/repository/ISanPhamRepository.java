package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ISanPhamRepository extends JpaRepository<SanPham, String> {
    Page<SanPham> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from products p where p.ma_san_pham like %:key% or p.ten like %:key%", nativeQuery = true)
    List<SanPham> findAllByKey(String key);
}
