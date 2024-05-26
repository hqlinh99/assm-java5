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

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MauSacController {

    private final MauSacService mauSacService;

    @GetMapping("/products/colors")
    public String pTable(@ModelAttribute("mauSac") MauSac mauSac,
                         @RequestParam(value = "key", required = false) Integer key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                         Model model) {
        Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll(status), page, pageSize);
        model.addAttribute("colors", mauSacPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", mauSacPage.getTotalPages());
        return "/colors-table.jsp";
    }

    @GetMapping("/color/{id}")
    public MauSac getColorById(@PathVariable("id") String id) {
        return mauSacService.findById(id);
    }

    @GetMapping("/color/search")
    public String findByKey(@RequestParam("key") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findByKey(key), page, pageSize);
        model.addAttribute("colors", mauSacPage.getContent());
        return "redirect:/products/colors";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/color/create")
    public String createColor(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                             BindingResult result,
                             @RequestParam(value = "id", required = false) String id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        if (result.hasErrors()) {
            Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll("all"), page, pageSize);
            model.addAttribute("colors", mauSacPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", mauSacPage.getTotalPages());
            return "/colors-table.jsp";
        }

        if (!id.isBlank()) {
            mauSac.setId(id);
            mauSacService.update(mauSac);
        } else {
            mauSacService.create(mauSac);
        }

        return "redirect:/products/colors";
    }

    @GetMapping("/color/update")
    public String updateColor(@RequestParam("id") String id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        MauSac mauSac1 = mauSacService.findById(id);
        model.addAttribute("mauSac", mauSac1);
        Page<MauSac> mauSacPage = PageUtil.createPage(mauSacService.findAll("all"), page, pageSize);
        model.addAttribute("colors", mauSacPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", mauSacPage.getTotalPages());
        return "/colors-table.jsp";
    }

    @GetMapping("/colors/delete")
    public String deleteColor(@RequestParam("id") String id) {
        mauSacService.delete(id);
        return "redirect:/products/colors";
    }

}
