package com.poly.assignment.controller;

import com.poly.assignment.entity.GioHang;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.SanPhamChiTietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GioHangController {

    private final GioHangService gioHangService;

    @GetMapping("/add-to-cart")
    public String addToCart(
            @RequestParam("pid") String pid,
            @RequestParam("pdid") String pdid) {
        if (pdid != null) {

            gioHangService.addToCart(pdid);
        }
        return "redirect:/product-" + pid + "/details";

    }

    @GetMapping("/decrease-quantity-in-cart-item")
    public String decreaseQuantityInCart(@RequestParam("cid") String cid) throws IOException {
        if (cid != null && !cid.equals(""))
            gioHangService.decreaseQuantityInCart(cid);
        return "redirect:/checkout";

    }

    @GetMapping("/increase-quantity-in-cart-item")
    public String increaseQuantityInCart(@RequestParam("cid") String cid) throws IOException {
        if (cid != null && !cid.equals(""))
            gioHangService.increaseQuantityInCart(cid);

        return "redirect:/checkout";

    }

    @GetMapping("/delete-item-in-cart")
    public String deleteItemInCart(@RequestParam("pdid") String pdid) {
        if (pdid != null && !pdid.equals(""))
            gioHangService.deleteItemInCart(pdid);
        return "redirect:/checkout";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        gioHangService.deleteAll();
        return "redirect:/checkout";
    }

}
