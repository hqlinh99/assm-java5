package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.IKichThuocRepository;
import com.poly.assignment.repository.IMauSacRepository;
import com.poly.assignment.repository.ISanPhamChiTietRepository;
import com.poly.assignment.repository.ISanPhamRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SanPhamChiTietService {

    private final MauSacService mauSacService;

    private final KichThuocService kichThuocService;

    private final SanPhamService sanPhamService;

    private final ISanPhamChiTietRepository sanPhamChiTietRepository;

    private final FileUploadService fileUploadService;

    public Page<SanPhamChiTiet> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return sanPhamChiTietRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return sanPhamChiTietRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public SanPhamChiTiet findById(String id) {
        return sanPhamChiTietRepository.findById(id).orElse(null);
    }

    public Page<SanPhamChiTiet> findAllSanPhamChiTietBySanPhamId(String page, String pageSize, String status, String pid) {
        if (status != null && !status.equals("all")) {
            return sanPhamChiTietRepository.findAllBySanPhamIdAndTrangThai(PageUtils.getPageable(page, pageSize), pid, Boolean.parseBoolean(status));
        }
        return sanPhamChiTietRepository.findAllBySanPhamId(PageUtils.getPageable(page, pageSize), pid);
    }

    public Page<SanPhamChiTiet> findByKey(String key) {
        return new PageImpl<>(sanPhamChiTietRepository.findAllByKey(key));
    }

    public void create(SanPhamChiTiet sanPhamChiTiet, String pid, MultipartFile file) throws IOException {
        sanPhamChiTiet.setId(UUID.randomUUID().toString());
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(pid));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet, String pid, MultipartFile file) throws IOException {
        if (sanPhamChiTiet.getId() != null) {
            String anh = fileUploadService.uploadFile(file);
            if (anh != null)
                sanPhamChiTiet.setHinhAnh(anh);
            sanPhamChiTiet.setSanPham(sanPhamService.findById(pid));
            sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
            sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
            sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
    }

    public void delete(String id) {
        sanPhamChiTietRepository.deleteById(id);
    }

}
