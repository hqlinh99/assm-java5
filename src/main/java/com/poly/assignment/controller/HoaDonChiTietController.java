package com.poly.assignment.controller;

import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.service.HoaDonChiTietService;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HoaDonChiTietController {

    private final HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/admin/hoa-don-chi-tiet")
    public Page<HoaDonChiTiet> getOrderDetails(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return hoaDonChiTietService.findAll(page, pageSize);
    }

    @GetMapping("/admin/hoa-don-chi-tiet/{id}")
    public HoaDonChiTiet getOrderDetailById(@PathVariable("id") String id) {
        return hoaDonChiTietService.findById(id);
    }

    @GetMapping("/admin/hoa-don/{id}")
    public Page<HoaDonChiTiet> getAllHoaDonChiTietByHoaDonId(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                             @PathVariable("id") String id) {
        return PageUtil.createPage(hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id), page, pageSize);
    }

}
