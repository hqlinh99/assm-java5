package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();

    private NhanVienService nhanVienService;
    private KhachHangService khachHangService;
    private HoaDonChiTietService hoaDonChiTietService;

    private @Autowired AuthService authService;

    private @Autowired GioHangService gioHangService;
    public HoaDonService(NhanVienService nhanVienService, KhachHangService khachHangService, @Lazy HoaDonChiTietService hoaDonChiTietService) {
        this.nhanVienService = nhanVienService;
        this.khachHangService = khachHangService;
        this.hoaDonChiTietService = hoaDonChiTietService;
        listHoaDon.add(new HoaDon("1", nhanVienService.findById("4"), khachHangService.findById("1"), new Date(), true));
        listHoaDon.add(new HoaDon("2", nhanVienService.findById("2"), khachHangService.findById("3"), new Date(), true));
        listHoaDon.add(new HoaDon("3", nhanVienService.findById("3"), khachHangService.findById("3"), new Date(), true));
        listHoaDon.add(new HoaDon("4", nhanVienService.findById("1"), khachHangService.findById("5"), new Date(), true));
        listHoaDon.add(new HoaDon("5", nhanVienService.findById("5"), khachHangService.findById("4"), new Date(), true));
    }

    public List<HoaDon> findAll(String status) {
        if (status.equals("true")) return listHoaDon.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listHoaDon.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listHoaDon;
    }

    public HoaDon findById(String id) {
        return listHoaDon.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);
    }

    public List<HoaDon> findByKey(String key) {
        return listHoaDon.stream()
                .filter(hd -> hd.getId().contains(key)
                        || hd.getKhachHang().getTen().contains(key)
                        || hd.getNhanVien().getTen().contains(key)
                        || hd.getNhanVien().getMaNV().contains(key)
                        || hd.getNhanVien().getTen().contains(key)
                        || hd.getNhanVien().getMaNV().contains(key))
                .collect(Collectors.toList());
    }

    public void create(HoaDon hoaDon) {
        hoaDon.setId(UUID.randomUUID().toString());
        hoaDon.setNhanVien(authService.getCurrentUser());
        hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
        hoaDon.setTrangThai(true);

        gioHangService.gioHangList.forEach(item -> {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSanPhamChiTiet(item.getSanPhamChiTiet());
            hoaDonChiTiet.setSoLuong(item.getQuantity());
            hoaDonChiTiet.setDonGia(item.getSanPhamChiTiet().getDonGia());
            hoaDonChiTietService.create(hoaDonChiTiet);
        });
        gioHangService.deleteAll();
        listHoaDon.add(hoaDon);
    }

    public void update(HoaDon hoaDon) {
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (listHoaDon.get(i).getId().equals(hoaDon.getId())) {
                hoaDon.setNhanVien(authService.getCurrentUser());
                hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
                listHoaDon.set(i, hoaDon);
            }
        }
    }

    public void cancel(String id) {
        findById(id).setTrangThai(false);
    }

}
