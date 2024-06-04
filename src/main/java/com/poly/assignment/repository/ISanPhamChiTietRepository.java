package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, String> {

    Page<SanPhamChiTiet> findAllBySanPhamIdAndTrangThai(Pageable pageable, String pid, boolean parseBoolean);

    Page<SanPhamChiTiet> findAllBySanPhamId(Pageable pageable, String pid);
}
