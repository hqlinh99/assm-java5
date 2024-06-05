package com.poly.assignment.repository;

import com.poly.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMauSacRepository extends JpaRepository<MauSac, String> {

    Page<MauSac> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from colors e where e.ma_mau_sac like %:key% or e.ten like %:key%", nativeQuery = true)
    List<MauSac> findAllByKey(String key);

}
