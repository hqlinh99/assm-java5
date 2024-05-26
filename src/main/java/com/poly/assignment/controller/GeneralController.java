package com.poly.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.service.AuthService;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.SanPhamService;
import com.poly.assignment.util.PageUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GeneralController {

    private final GioHangService gioHangService;

    private final SanPhamService sanPhamService;

    private final AuthService authService;

    @GetMapping
    public String index(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                        Model model) {
        Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll("all"), page, pageSize);
        model.addAttribute("products", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        model.addAttribute("cart", gioHangService.findAll());
        return "/index.jsp";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login.jsp";
    }

    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("auth") Auth auth, BindingResult bindingResult, Model model) throws JsonProcessingException {
        model.addAttribute("auth", auth);
        String message = authService.login(auth);
        if (message == null)
            return "redirect:";

        model.addAttribute("message", message);
        return "/login.jsp";
    }

}
