package com.poly.assignment.controller;

import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.SanPhamChiTietService;
import com.poly.assignment.service.SanPhamService;
import com.poly.assignment.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class SanPhamChiTietController {

    private final SanPhamChiTietService sanPhamChiTietService;
    private final SanPhamService sanPhamService;

    private final GioHangService gioHangService;

    @GetMapping("/product-{pid}/details")
    public String getAllProductDetailByProductId(@PathVariable("pid") String pid,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                                                 Model model) {
        model.addAttribute("sanPham", sanPhamService.findById(pid));
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAllSanPhamChiTietBySanPhamId(pid), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        model.addAttribute("cart", gioHangService.findAll());
        return "/product-details.jsp";
    }

    @GetMapping("/product-{pid}/details/search")
    public String findByKey(@PathVariable("pid") String pid,
                            @RequestParam("key") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                            Model model) {
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findByKey(key), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        return "redirect:/product-" + pid + "/details";
    }

}
