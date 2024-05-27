package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService sanPhamService;

    @GetMapping("/products/table")
    public String pTable(@ModelAttribute("sanPham") SanPham sanPham,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("products", sanPhamService.findByKey(key));
        } else {
            Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll(status), page, pageSize);
            model.addAttribute("products", sanPhamPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", sanPhamPage.getTotalPages());
            model.addAttribute("status", status);
        }
        return "/products-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute("sanPham") SanPham sanPham,
                                BindingResult result,
                                MultipartFile file,
                                @RequestParam(value = "pid", required = false) String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll("all"), page, pageSize);
            model.addAttribute("products", sanPhamPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", sanPhamPage.getTotalPages());
            return "/products-table.jsp";
        }

        if (pid != null && !pid.isBlank()) {
            sanPham.setId(pid);
            sanPhamService.update(sanPham, file);
        } else {
            sanPhamService.create(sanPham, file);
        }

        return "redirect:/products/table";
    }

    @GetMapping("/products/update")
    public String updateProduct(@RequestParam("pid") String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        model.addAttribute("sanPham", sanPhamService.findById(pid));
        Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll("all"), page, pageSize);
        model.addAttribute("products", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        return "/products-table.jsp";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam("pid") String pid) {
        sanPhamService.delete(pid);

        return "redirect:/products/table";
    }

}
