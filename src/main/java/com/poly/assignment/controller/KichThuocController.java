package com.poly.assignment.controller;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.service.KichThuocService;
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
public class KichThuocController {

    private final KichThuocService kichThuocService;

    @GetMapping("/sizes/table")
    public String pTable(@ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("ePage", kichThuocService.findByKey(key));
        } else {
            model.addAttribute("ePage", kichThuocService.findAll(page, pageSize, status));
            model.addAttribute("status", status);
        }
        return "/sizes-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/sizes/create")
    public String createProduct(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                                BindingResult result,
                                @RequestParam(value = "pid", required = false) String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ePage", kichThuocService.findAll(page, pageSize, null));
            return "/sizes-table.jsp";
        }

        if (pid != null && !pid.isBlank()) {
            kichThuoc.setId(pid);
            kichThuocService.update(kichThuoc);
        } else {
            kichThuocService.create(kichThuoc);
        }

        return "redirect:/sizes/table";
    }

    @GetMapping("/sizes/update")
    public String updateProduct(@RequestParam("pid") String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("kichThuoc", kichThuocService.findById(pid));
        model.addAttribute("ePage", kichThuocService.findAll(page, pageSize, null));
        return "/sizes-table.jsp";
    }

    @GetMapping("/sizes/delete")
    public String deleteProduct(@RequestParam("pid") String pid) {
        kichThuocService.delete(pid);

        return "redirect:/sizes/table";
    }

}
