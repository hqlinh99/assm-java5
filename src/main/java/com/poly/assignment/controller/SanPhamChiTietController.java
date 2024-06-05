package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
import com.poly.assignment.repository.IKichThuocRepository;
import com.poly.assignment.repository.IMauSacRepository;
import com.poly.assignment.repository.ISanPhamRepository;
import com.poly.assignment.service.*;
import com.poly.assignment.util.PageUtils;
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
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SanPhamChiTietController {

    private final SanPhamChiTietService sanPhamChiTietService;
    private final IKichThuocRepository kichThuocRepository;
    private final IMauSacRepository mauSacRepository;
    private final ISanPhamRepository sanPhamRepository;

    @GetMapping("/product-{pid}/details/table")
    public String pTable(@ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                         @PathVariable("pid") String pid,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") String pageSize,
                         Model model) {
        if (pid != null) {
            model.addAttribute("sizes", kichThuocRepository.findAll());
            model.addAttribute("colors", mauSacRepository.findAll());
            model.addAttribute("sanPham", sanPhamRepository.findById(pid).orElse(null));
            if (key != null) {
                model.addAttribute("key", key);
                model.addAttribute("ePage", sanPhamChiTietService.findBySanPhamIdAndKey(pid, key));
            } else {
                model.addAttribute("ePage", sanPhamChiTietService.findAllBySanPhamId(page, pageSize, pid, status));
                model.addAttribute("status", status);
            }
            return "/product-details-table.jsp";
        }
        return "redirect:/products/table";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/product-{pid}/details/create")
    public String createProduct(@Valid @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                                BindingResult result,
                                @PathVariable("pid") String pid,
                                MultipartFile file,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("sizes", kichThuocRepository.findAll());
            model.addAttribute("colors", mauSacRepository.findAll());
            model.addAttribute("sanPham", sanPhamRepository.findById(pid).orElse(null));
            model.addAttribute("ePage", sanPhamChiTietService.findAllBySanPhamId(page, pageSize, pid, null));
            return "/product-details-table.jsp";
        }

        if (id != null && !id.isBlank()) {
            sanPhamChiTietService.update(sanPhamChiTiet, file);
        } else {
            sanPhamChiTietService.create(sanPhamChiTiet, file);
        }

        return "redirect:/product-" + pid + "/details/table";
    }

    @GetMapping("/product-{pid}/details/update")
    public String updateProduct(@RequestParam("id") String id,
                                @PathVariable("pid") String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("sizes", kichThuocRepository.findAll());
        model.addAttribute("colors", mauSacRepository.findAll());
        model.addAttribute("sanPham", sanPhamRepository.findById(pid).orElse(null));
        model.addAttribute("sanPhamChiTiet", sanPhamChiTietService.findById(id));
        model.addAttribute("ePage", sanPhamChiTietService.findAllBySanPhamId(page, pageSize, pid, null));
        return "/product-details-table.jsp";
    }

    @GetMapping("/product-{pid}/details/delete")
    public String deleteProduct(@RequestParam("id") String id,
                                @PathVariable("pid") String pid) {
        sanPhamChiTietService.delete(id);

        return "redirect:/product-" + pid + "/details/table";
    }

}
