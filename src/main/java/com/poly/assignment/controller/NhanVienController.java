package com.poly.assignment.controller;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.service.NhanVienService;
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
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping("/employees/table")
    public String pTable(@ModelAttribute("nhanVien") NhanVien nhanVien,
                         @RequestParam(value = "key", required = false) String key,
                         @RequestParam(value = "status", required = false, defaultValue = "all") String status,
                         @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                         Model model) {
        if (key != null) {
            model.addAttribute("key", key);
            model.addAttribute("ePage", nhanVienService.findByKey(key));
        } else {
            model.addAttribute("ePage", nhanVienService.findAll(page, pageSize, status));
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
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("ePage", nhanVienService.findAll(page, pageSize, null));
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
                                @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSize,
                                Model model) {
        model.addAttribute("nhanVien", nhanVienService.findById(id));
        model.addAttribute("ePage", nhanVienService.findAll(page, pageSize, null));
        return "/employees-table.jsp";
    }

    @GetMapping("/employees/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        nhanVienService.delete(id);

        return "redirect:/employees/table";
    }

}
