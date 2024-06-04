package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, String> {
    List<HoaDonChiTiet> findAllByHoaDonId(String id);
}
