package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
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
public class SanPhamService {

    private final ISanPhamRepository sanPhamRepository;
    private final FileUploadService fileUploadService;

    public Page<SanPham> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return sanPhamRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return sanPhamRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public SanPham findById(String id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    public Page<SanPham> findByKey(String key) {
        return new PageImpl<>(sanPhamRepository.findAllByKey(key));
    }

    public void create(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamRepository.save(sanPham);
    }

    public void update(SanPham sanPham, MultipartFile file) throws IOException {
        if (sanPham.getId() != null) {
            String anh = fileUploadService.uploadFile(file);
            if (anh != null)
                sanPham.setHinhAnh(anh);
            else sanPham.setHinhAnh(findById(sanPham.getId()).getHinhAnh());
            sanPhamRepository.save(sanPham);
        }
    }

    public void delete(String id) {
        sanPhamRepository.deleteById(id);
    }

}
