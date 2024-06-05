package com.poly.assignment.controller;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.service.MauSacService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MauSacController {

    private final MauSacService mauSacService;

    @GetMapping("/colors/table")
    public String pTable(@ModelAttribute("mauSac") MauSac mauSac,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("ePage", mauSacService.findByKey(key));
        } else {
            model.addAttribute("ePage", mauSacService.findAll(page, pageSize, status));
            model.addAttribute("status", status);
        }
        return "/colors-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/colors/create")
    public String createProduct(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                                BindingResult result,
                                @RequestParam(value = "pid", required = false) String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ePage", mauSacService.findAll(page, pageSize, null));
            return "/colors-table.jsp";
        }

        if (pid != null && !pid.isBlank()) {
            mauSac.setId(pid);
            mauSacService.update(mauSac);
        } else {
            mauSacService.create(mauSac);
        }

        return "redirect:/colors/table";
    }

    @GetMapping("/colors/update")
    public String updateProduct(@RequestParam("pid") String pid,
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("mauSac", mauSacService.findById(pid));
        model.addAttribute("ePage", mauSacService.findAll(page, pageSize, null));
        return "/colors-table.jsp";
    }

    @GetMapping("/colors/delete")
    public String deleteProduct(@RequestParam("pid") String pid) {
        mauSacService.delete(pid);

        return "redirect:/colors/table";
    }

}
