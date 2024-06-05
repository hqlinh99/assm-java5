package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.repository.IMauSacRepository;
import com.poly.assignment.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MauSacService {

    private final IMauSacRepository mauSacRepository;

    public Page<MauSac> findAll(String page, String pageSize, String status) {
        if (status != null && !status.equals("all")) {
            return mauSacRepository.findAllByTrangThai(PageUtils.getPageable(page, pageSize), Boolean.parseBoolean(status));
        }
        return mauSacRepository.findAll(PageUtils.getPageable(page, pageSize));
    }

    public MauSac findById(String id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    public Page<MauSac> findByKey(String key) {
        return new PageImpl<>(mauSacRepository.findAllByKey(key));
    }

    public void create(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    public void update(MauSac mauSac) {
        if (mauSac.getId() != null) {
            mauSacRepository.save(mauSac);
        }
    }

    public void delete(String id) {
        mauSacRepository.deleteById(id);
    }

}
