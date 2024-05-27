package com.poly.assignment.controller;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.service.NhanVienService;
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
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping("/employees/table")
    public String pTable(@ModelAttribute("nhanVien") NhanVien nhanVien,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("employees", nhanVienService.findByKey(key));
        } else {
            Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll(status), page, pageSize);
            model.addAttribute("employees", nhanVienPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", nhanVienPage.getTotalPages());
            model.addAttribute("status", status);
        }
        return "/employees-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/employees/create")
    public String createProduct(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
                                BindingResult result,
                                MultipartFile file,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll("all"), page, pageSize);
            model.addAttribute("employees", nhanVienPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", nhanVienPage.getTotalPages());
            return "/employees-table.jsp";
        }

        if (id != null && !id.isBlank()) {
            nhanVien.setId(id);
            nhanVienService.update(nhanVien, file);
        } else {
            nhanVienService.create(nhanVien, file);
        }

        return "redirect:/employees/table";
    }

    @GetMapping("/employees/update")
    public String updateProduct(@RequestParam("id") String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        model.addAttribute("nhanVien", nhanVienService.findById(id));
        Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll("all"), page, pageSize);
        model.addAttribute("employees", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "/employees-table.jsp";
    }

    @GetMapping("/employees/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        nhanVienService.delete(id);

        return "redirect:/employees/table";
    }

}
