package com.poly.assignment.controller;

import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.repository.IKhachHangRepository;
import com.poly.assignment.repository.INhanVienRepository;
import com.poly.assignment.repository.ISanPhamChiTietRepository;
import com.poly.assignment.service.HoaDonChiTietService;
import com.poly.assignment.service.HoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;
    private final HoaDonChiTietService hoaDonChiTietService;
    private final ISanPhamChiTietRepository sanPhamChiTietRepository;
    private final IKhachHangRepository khachHangRepository;
    private final INhanVienRepository nhanVienRepository;


    @GetMapping("/invoices/table")
    public String pTable(@ModelAttribute("hoaDon") HoaDon hoaDon,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") String pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("ePage", hoaDonService.findByKey(key));
        } else {
            model.addAttribute("ePage", hoaDonService.findAll(page, pageSize, status));
            model.addAttribute("status", status);
        }
        return "/invoices-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/invoices/create")
    public String createInvoice(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
                                BindingResult result,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("ePage", hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(page, pageSize, id, null));
            model.addAttribute("customers", khachHangRepository.findAll());
            model.addAttribute("employees", nhanVienRepository.findAll());
            model.addAttribute("productDetails", sanPhamChiTietRepository.findAll());
            return "/invoice-update.jsp";
        }

        if (id != null && !id.isBlank()) {
            hoaDonService.update(hoaDon);
            return "redirect:/invoices/update?id=" + id;
        } else {
            hoaDonService.create(hoaDon);
        }
        return "redirect:/invoices/table";
    }

    @GetMapping("/invoices/update")
    public String updateInvoice(@RequestParam("id") String id,
                                @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("hoaDon", hoaDonService.findById(id));
        model.addAttribute("ePage", hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(page, pageSize, id, status));
        model.addAttribute("customers", khachHangRepository.findAll());
        model.addAttribute("employees", nhanVienRepository.findAll());
        model.addAttribute("productDetails", sanPhamChiTietRepository.findAll());
        model.addAttribute("status", status);
        return "/invoice-update.jsp";
    }

    @GetMapping("/invoices/delete")
    public String deleteInvoice(@RequestParam("id") String id) {
        hoaDonService.delete(id);

        return "redirect:/invoices/table";
    }

}
