package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.repository.IKichThuocRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KichThuocService {

    private final IKichThuocRepository kichThuocRepository;

    public Page<KichThuoc> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return kichThuocRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return kichThuocRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public KichThuoc findById(String id) {
        return kichThuocRepository.findById(id).orElse(null);
    }

    public Page<KichThuoc> findByKey(String key) {
        return new PageImpl<>(kichThuocRepository.findAllByKey(key));
    }

    public void create(KichThuoc kichThuoc) {
        kichThuocRepository.save(kichThuoc);
    }

    public void update(KichThuoc kichThuoc) {
        if (kichThuoc.getId() != null) {
            kichThuocRepository.save(kichThuoc);
        }
    }

    public void delete(String id) {
        kichThuocRepository.deleteById(id);
    }

}
