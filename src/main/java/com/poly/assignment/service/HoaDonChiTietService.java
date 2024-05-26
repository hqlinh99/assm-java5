package com.poly.assignment.service;

import com.poly.assignment.entity.*;
import com.poly.assignment.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietService {

    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();

    private SanPhamChiTietService sanPhamChiTietService;

    public HoaDonChiTietService(HoaDonService hoaDonService, SanPhamChiTietService sanPhamChiTietService) {
        this.sanPhamChiTietService = sanPhamChiTietService;
        listHoaDonChiTiet.add(new HoaDonChiTiet("1", hoaDonService.findById("1"), sanPhamChiTietService.findById("1"), 2, 50.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("2", hoaDonService.findById("2"), sanPhamChiTietService.findById("2"), 1, 100.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("3", hoaDonService.findById("3"), sanPhamChiTietService.findById("3"), 1, 150.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("4", hoaDonService.findById("4"), sanPhamChiTietService.findById("1"), 3, 50.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("5", hoaDonService.findById("5"), sanPhamChiTietService.findById("2"), 2, 100.0, true));
    }

    public Page<HoaDonChiTiet> findAll(int page, int pageSize) {
        return PageUtil.createPage(listHoaDonChiTiet, page, pageSize);
    }

    public HoaDonChiTiet findById(String id) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(id)) {
                return hoaDonChiTiet;
            }
        }

        return null;
    }

    public List<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(String id) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getHoaDon().getId().equals(id)) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public void create(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTiet.setId(UUID.randomUUID().toString());
        listHoaDonChiTiet.add(hoaDonChiTiet);
    }

    public void update(HoaDonChiTiet hoaDonChiTiet) {
        for (int i = 0; i < listHoaDonChiTiet.size(); i++) {
            if (listHoaDonChiTiet.get(i).getId().equals(hoaDonChiTiet.getId())) {
                listHoaDonChiTiet.set(i, hoaDonChiTiet);
            }
        }
    }

    public void delete(String id) {
        List<HoaDonChiTiet> deList = new ArrayList<>();
        for (int i = 0; i < listHoaDonChiTiet.size(); i++) {
            if (listHoaDonChiTiet.get(i).getId().equals(id)) {
                deList.add(listHoaDonChiTiet.get(i));
            }
        }

        listHoaDonChiTiet.removeAll(deList);
    }

    public void decreaseQuantity(String idid) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(idid)) {
                hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() - 1);
            }
        }
    }

    public void increaseQuantity(String idid) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(idid)) {
                hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + 1);
            }
        }
    }

    public void updateProductDetail(String idid, String pdid) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(idid)) {
                hoaDonChiTiet.setSanPhamChiTiet(sanPhamChiTietService.findById(pdid));
            }
        }
    }

    public void updateStatus(String idid) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(idid)) {
                hoaDonChiTiet.setTrangThai(!hoaDonChiTiet.getTrangThai());
            }
        }
    }
}
