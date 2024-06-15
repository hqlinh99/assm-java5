package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.IHoaDonChiTietRepository;
import com.poly.assignment.repository.IHoaDonRepository;
import com.poly.assignment.repository.ISanPhamChiTietRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HoaDonService {

    private final IHoaDonChiTietRepository hoaDonChiTietRepository;
    private final IHoaDonRepository hoaDonRepository;
    private final GioHangService gioHangService;
    private final AuthService authService;
    private final ISanPhamChiTietRepository sanPhamChiTietRepository;

    public Page<HoaDon> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return hoaDonRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return hoaDonRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public HoaDon findById(String id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    public Page<HoaDon> findByKey(String key) {
        return new PageImpl<>(hoaDonRepository.findAllByKey(key));
    }

    public void create(HoaDon hoaDon) throws IOException {
        HoaDon hoaDonResult = hoaDonRepository.save(hoaDon);

        gioHangService.gioHangList.forEach(i -> {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(i.getSanPhamChiTiet().getId()).orElse(null);
            hoaDonChiTiet.setHoaDon(hoaDonResult);
            hoaDonChiTiet.setDonGia(i.getSanPhamChiTiet().getDonGia());
            hoaDonChiTiet.setSoLuong(i.getQuantity());
            hoaDonChiTiet.setSanPhamChiTiet(sanPhamChiTiet);
            hoaDonChiTiet.setTrangThai(true);
            hoaDonChiTietRepository.save(hoaDonChiTiet);
        });
        gioHangService.deleteAll();
    }

    public void update(HoaDon hoaDon) throws IOException {
        if (hoaDon.getId() != null) {
            hoaDonRepository.save(hoaDon);
        }
    }

    public void delete(String id) {
        hoaDonRepository.deleteById(id);
    }

}
