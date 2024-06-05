package com.poly.assignment.repository;

import com.poly.assignment.entity.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IKichThuocRepository extends JpaRepository<KichThuoc, String> {

    Page<KichThuoc> findAllByTrangThai(Pageable pageable, boolean status);

    @Query(value = "select * from sizes e where e.ma_kich_thuoc like %:key% or e.ten like %:key%", nativeQuery = true)
    List<KichThuoc> findAllByKey(String key);

}
