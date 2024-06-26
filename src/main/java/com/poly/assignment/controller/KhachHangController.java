package com.poly.assignment.controller;
import com.poly.assignment.entity.KhachHang;
import com.poly.assignment.service.KhachHangService;
import com.poly.assignment.util.PageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping("/customers/table")
    public String pTable(@ModelAttribute("khachHang") KhachHang khachHang,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("ePage", khachHangService.findByKey(key));
        } else {
            model.addAttribute("ePage", khachHangService.findAll(page, pageSize, status));
            model.addAttribute("status", status);
        }
        return "/customers-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/customers/create")
    public String createCustomer(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                                BindingResult result,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ePage", khachHangService.findAll(page, pageSize, null));
            return "/customers-table.jsp";
        }

        if (id != null && !id.isBlank()) {
            khachHang.setId(id);
            khachHangService.update(khachHang);
        } else {
            khachHangService.create(khachHang);
        }

        return "redirect:/customers/table";
    }

    @GetMapping("/customers/update")
    public String updateCustomer(@RequestParam("id") String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("khachHang", khachHangService.findById(id));
        model.addAttribute("ePage", khachHangService.findAll(page, pageSize, null));
        return "/customers-table.jsp";
    }

    @GetMapping("/customers/delete")
    public String deleteCustomer(@RequestParam("id") String id) {
        khachHangService.delete(id);

        return "redirect:/customers/table";
    }

}
