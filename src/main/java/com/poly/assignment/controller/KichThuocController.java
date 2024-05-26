package com.poly.assignment.controller;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.service.KichThuocService;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KichThuocController {

    private final KichThuocService kichThuocService;

    @GetMapping("/products/sizes")
    public String pTable(@ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                         Model model) {
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());
        return "/sizes-table.jsp";
    }

    @GetMapping("/size/{id}")
    public KichThuoc getSizeById(@PathVariable("id") String id) {
        return kichThuocService.findById(id);
    }

    @GetMapping("/size/search")
    public String findByKey(@RequestParam("key") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findByKey(key), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        return "redirect:/products/sizes";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/size/create")
    public String createSize(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                             BindingResult result,
                             @RequestParam(value = "id", required = false) String id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        if (result.hasErrors()) {
            Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
            model.addAttribute("sizes", kichThuocPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", kichThuocPage.getTotalPages());
            return "/sizes-table.jsp";
        }

        if (!id.isBlank()) {
            kichThuoc.setId(id);
            kichThuocService.update(kichThuoc);
        } else {
            kichThuocService.create(kichThuoc);
        }

        return "redirect:/products/sizes";
    }

    @GetMapping("/size/update")
    public String updateSize(@RequestParam("id") String id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        KichThuoc kichThuoc1 = kichThuocService.findById(id);
        model.addAttribute("kichThuoc", kichThuoc1);
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());
        return "/sizes-table.jsp";
    }

    @GetMapping("/sizes/delete")
    public String deleteSize(@RequestParam("id") String id) {
        kichThuocService.delete(id);
        return "redirect:/products/sizes";
    }

}
