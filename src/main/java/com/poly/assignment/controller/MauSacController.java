package com.poly.assignment.controller;
import com.poly.assignment.entity.MauSac;
import com.poly.assignment.service.MauSacService;
import com.poly.assignment.util.PageUtil;
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
public class MauSacController {

    private final MauSacService mauSacService;

    @GetMapping("/colors/table")
    public String pTable(@ModelAttribute("mauSac") MauSac mauSac,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("colors", mauSacService.findByKey(key));
        } else {
            Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll(status), page, pageSize);
            model.addAttribute("colors", mauSacPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", mauSacPage.getTotalPages());
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
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll("all"), page, pageSize);
            model.addAttribute("colors", mauSacPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", mauSacPage.getTotalPages());
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
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        model.addAttribute("mauSac", mauSacService.findById(pid));
        Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll("all"), page, pageSize);
        model.addAttribute("colors", mauSacPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", mauSacPage.getTotalPages());
        return "/colors-table.jsp";
    }

    @GetMapping("/colors/delete")
    public String deleteProduct(@RequestParam("pid") String pid) {
        mauSacService.delete(pid);

        return "redirect:/colors/table";
    }

}
