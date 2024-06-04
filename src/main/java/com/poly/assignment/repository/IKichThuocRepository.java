package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKichThuocRepository extends JpaRepository<KichThuoc, String> {
}
