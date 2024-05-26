package com.poly.assignment.controller;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.service.*;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class SanPhamChiTietController {

    private final SanPhamChiTietService sanPhamChiTietService;

    private final SanPhamService sanPhamService;

    private final GioHangService gioHangService;

    private final KichThuocService kichThuocService;

    private final MauSacService mauSacService;

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

    @GetMapping("/product-{pid}/details-table")
    public String productDetailPage(@PathVariable("pid") String pid,
                                                 @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                                                 Model model) {
        SanPham sanPham = sanPhamService.findById(pid);
        if (sanPham == null) return "redirect:/products/table";
        model.addAttribute("sanPham", sanPhamService.findById(pid));
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAllSanPhamChiTietBySanPhamId(pid), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        model.addAttribute("cart", gioHangService.findAll());
        return "/product-details-table.jsp";
    }

    @GetMapping("/product-{pid}/details-update")
    public String productDetailUpdatePage(@PathVariable("pid") String pid,
                                    @RequestParam(value = "pdid", required = false) String pdid,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                                    Model model) {
        SanPham sanPham = sanPhamService.findById(pid);
        SanPhamChiTiet spct = sanPhamChiTietService.findById(pdid);
        if (sanPham == null) return "redirect:/products/table";
        else
            if (spct == null) return "redirect:/product-" + pid + "/details";

        model.addAttribute("cart", gioHangService.findAll());
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("sanPhamChiTiet", spct);
        model.addAttribute("sizes", kichThuocService.findAll("true"));
        model.addAttribute("colors", mauSacService.findAll("true"));
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAllSanPhamChiTietBySanPhamId(pid), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        return "/product-details-table.jsp";
    }

    @PostMapping("/product-{pid}/details/create")
    public String createProduct(@Valid @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                                BindingResult result,
                                MultipartFile file,
                                @PathVariable("pid") String pid,
                                @RequestParam(value = "pdid", required = false) String pdid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAllSanPhamChiTietBySanPhamId(pid), page, pageSize);
            model.addAttribute("products", sanPhamChiTietPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
            return "/products-table.jsp";
        }

        if (pid != null && !pid.isBlank()) {
            sanPhamChiTiet.setId(pdid);
            sanPhamChiTietService.update(sanPhamChiTiet, pid,file);
        } else {
            sanPhamChiTietService.create(sanPhamChiTiet, pid,file);
        }

        return "redirect:/products/table";
    }

}
