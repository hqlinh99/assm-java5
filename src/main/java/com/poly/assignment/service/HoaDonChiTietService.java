package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.IHoaDonChiTietRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonChiTietService {

    private final IHoaDonChiTietRepository hoaDonChiTietRepository;

    public Page<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(String page, String pageSize, String hdid, String status) {
        if (status != null && !status.equals("all")) {
            return hoaDonChiTietRepository.findAllByHoaDonIdAndTrangThai(PageUtils.getPageable(page, pageSize), hdid, Boolean.parseBoolean(status));
        }
        return hoaDonChiTietRepository.findAllByHoaDonId(PageUtils.getPageable(page, pageSize), hdid);
    }

    public HoaDonChiTiet findById(String id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    public void create(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void update(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void delete(String id) {
        hoaDonChiTietRepository.deleteById(id);
    }

    public void decreaseQuantity(String idid) {
        HoaDonChiTiet hoaDonChiTiet = findById(idid);
        if (hoaDonChiTiet != null) {
            hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + 1);
            hoaDonChiTietRepository.save(hoaDonChiTiet);
        }
    }

    public void increaseQuantity(String idid) {
        HoaDonChiTiet hoaDonChiTiet = findById(idid);
        if (hoaDonChiTiet != null) {
            hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() - 1);
            hoaDonChiTietRepository.save(hoaDonChiTiet);
        }
    }

    public void updateProductDetail(String idid, String pdid) {

    }

    public void updateStatus(String idid) {
        HoaDonChiTiet hoaDonChiTiet = findById(idid);

        if (hoaDonChiTiet != null) {
            hoaDonChiTiet.setTrangThai(!hoaDonChiTiet.getTrangThai());
        }
    }
}
