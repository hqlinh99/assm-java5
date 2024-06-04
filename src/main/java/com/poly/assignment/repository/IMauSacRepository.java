package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMauSacRepository extends JpaRepository<MauSac, String> {
}
