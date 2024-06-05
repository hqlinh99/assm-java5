package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.ISanPhamChiTietRepository;
import com.poly.assignment.repository.ISanPhamRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamChiTietService {

    private final ISanPhamChiTietRepository sanPhamChiTietRepository;
    private final FileUploadService fileUploadService;
    private final ISanPhamRepository sanPhamRepository;

    public Page<SanPhamChiTiet> findAllBySanPhamId(String page, String pageSize, String pid, String status) {
        if (status != null && !status.equals("all")) {
            return sanPhamChiTietRepository.findAllBySanPhamIdAndTrangThai(PageUtils.getPageable(page, pageSize), pid, Boolean.parseBoolean(status));
        }
        return sanPhamChiTietRepository.findAllBySanPhamId(PageUtils.getPageable(page, pageSize), pid);
    }

    public SanPhamChiTiet findById(String id) {
        return sanPhamChiTietRepository.findById(id).orElse(null);
    }

    public Page<SanPhamChiTiet> findBySanPhamIdAndKey(String pid, String key) {
        return new PageImpl<>(sanPhamChiTietRepository.findAllBySanPhamIdAndKey(pid, key));
    }

    public void create(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        if (sanPhamChiTiet.getId() != null) {
            String anh = fileUploadService.uploadFile(file);
            if (anh != null)
                sanPhamChiTiet.setHinhAnh(anh);
            else sanPhamChiTiet.setHinhAnh(findById(sanPhamChiTiet.getId()).getHinhAnh());
            sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
    }

    public void delete(String id) {
        sanPhamChiTietRepository.deleteById(id);
    }

}
