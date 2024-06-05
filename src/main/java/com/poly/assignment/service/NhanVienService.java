package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.repository.INhanVienRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NhanVienService {

    private final INhanVienRepository nhanVienRepository;
    private final FileUploadService fileUploadService;

    public Page<NhanVien> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return nhanVienRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return nhanVienRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public NhanVien findById(String id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public Page<NhanVien> findByKey(String key) {
        return new PageImpl<>(nhanVienRepository.findAllByKey(key));
    }

    public void create(NhanVien nhanVien, MultipartFile file) throws IOException {
        nhanVien.setHinhAnh(fileUploadService.uploadFile(file));
        nhanVienRepository.save(nhanVien);
    }

    public void update(NhanVien nhanVien, MultipartFile file) throws IOException {
        if (nhanVien.getId() != null) {
            String anh = fileUploadService.uploadFile(file);
            if (anh != null)
                nhanVien.setHinhAnh(anh);
            nhanVienRepository.save(nhanVien);
        }
    }

    public void delete(String id) {
        nhanVienRepository.deleteById(id);
    }

}
