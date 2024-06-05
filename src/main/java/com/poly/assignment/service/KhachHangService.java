package com.poly.assignment.service;

import com.poly.assignment.entity.KhachHang;
import com.poly.assignment.repository.IKhachHangRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KhachHangService {

    private final IKhachHangRepository khachHangRepository;

    public Page<KhachHang> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return khachHangRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return khachHangRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public KhachHang findById(String id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    public Page<KhachHang> findByKey(String key) {
        return new PageImpl<>(khachHangRepository.findAllByKey(key));
    }

    public void create(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    public void update(KhachHang khachHang) {
        if (khachHang.getId() != null) {
            khachHangRepository.save(khachHang);
        }
    }

    public void delete(String id) {
        khachHangRepository.deleteById(id);
    }

}
