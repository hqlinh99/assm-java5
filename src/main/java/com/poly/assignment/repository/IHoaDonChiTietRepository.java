package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, String> {
    Page<HoaDonChiTiet> findAllByHoaDonId(Pageable pageable, String hdid);

    Page<HoaDonChiTiet> findAllByHoaDonIdAndTrangThai(Pageable pageable, String hdid, boolean status);
}
