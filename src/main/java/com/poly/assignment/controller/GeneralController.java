package com.poly.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.service.AuthService;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.SanPhamChiTietService;
import com.poly.assignment.service.SanPhamService;
import com.poly.assignment.util.PageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class GeneralController {
    //
    private final GioHangService gioHangService;

    private final SanPhamService sanPhamService;

    private final SanPhamChiTietService sanPhamChiTietService;

    private final AuthService authService;


    @GetMapping
    public String index(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "8") String pageSize,
                        Model model) {
        model.addAttribute("ePage", sanPhamService.findAll(page, pageSize, null));
        model.addAttribute("cartService", gioHangService);
        return "/index.jsp";
    }

    @GetMapping("/product-{pid}/details")
    public String productDetailPage(@PathVariable("pid") String pid,
                                    @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "8") String pageSize,
                                    Model model) {
        SanPham sanPham = sanPhamService.findById(pid);
        if (sanPham == null) return "redirect:/";
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("ePage", sanPhamChiTietService.findAllSanPhamChiTietBySanPhamId(page, pageSize, null, pid));

        model.addAttribute("cartService", gioHangService);
        return "/product-details.jsp";
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

        if (bindingResult.hasErrors())
            return "/login.jsp";
        String message = authService.login(auth);
        if (message == null)
            return "redirect:";

        model.addAttribute("message", message);
        return "/login.jsp";
    }

}
