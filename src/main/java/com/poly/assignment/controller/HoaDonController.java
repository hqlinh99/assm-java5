//package com.poly.assignment.controller;
//
//import com.poly.assignment.entity.HoaDon;
//import com.poly.assignment.service.*;
//import com.poly.assignment.util.PageUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequiredArgsConstructor
//public class HoaDonController {
//
//    private final HoaDonService hoaDonService;
//
//    private final HoaDonChiTietService hoaDonChiTietService;
//
//    private final SanPhamChiTietService sanPhamChiTietService;
//
//    private final GioHangService gioHangService;
//
//    private final NhanVienService nhanVienService;
//
//    private final KhachHangService khachHangService;
//
//    @GetMapping("/checkout")
//    public String checkoutPage(Model model) {
//        model.addAttribute("cart", gioHangService.findAll());
//        model.addAttribute("cartService", gioHangService);
//        model.addAttribute("customers", khachHangService.findAll("true"));
//        return "/checkout.jsp";
//    }
//
//    @GetMapping("/invoices/table")
//    public String getOrders(@ModelAttribute("hoaDon") HoaDon hoaDon,
//                            @RequestParam(value = "key", required = false) String key,
//                            @RequestParam(value = "status", required = false, defaultValue = "all") String status,
//                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
//                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
//                            Model model) {
//        if (key != null) {
//            model.addAttribute("key", key);
//            model.addAttribute("products", hoaDonService.findByKey(key));
//        } else {
//            Page<HoaDon> hoaDonPage = PageUtils.createPage(hoaDonService.findAll(status), page, pageSize);
//            model.addAttribute("invoices", hoaDonPage.getContent());
//            model.addAttribute("currentPage", page);
//            model.addAttribute("pageSize", pageSize);
//            model.addAttribute("totalPages", hoaDonPage.getTotalPages());
//            model.addAttribute("status", status);
//        }
//        return "/invoices-table.jsp";
//    }
//
//    @PostMapping("/invoices/create")
//    public String createOrder(
//            @ModelAttribute("hoaDon") HoaDon hoaDon,
//            @RequestParam(value = "id", required = false) String id) {
//        if (id != null && !id.isBlank()) {
//            hoaDonService.update(hoaDon);
//        } else hoaDonService.create(hoaDon);
//
//        return "redirect:/invoices/table";
//    }
//
//    @GetMapping("/invoices/update")
//    public String updateProduct(@RequestParam("id") String id,
//                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
//                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
//                                Model model) {
//        HoaDon hoaDon = hoaDonService.findById(id);
//        if (hoaDon != null) {
//            model.addAttribute("hoaDon", hoaDon);
//            model.addAttribute("invoiceDetails", hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id));
//            model.addAttribute("productDetails", sanPhamChiTietService.findAll("true"));
//            Page<HoaDon> sanPhamPage = PageUtils.createPage(hoaDonService.findAll("all"), page, pageSize);
//            model.addAttribute("products", sanPhamPage.getContent());
//            model.addAttribute("currentPage", page);
//            model.addAttribute("pageSize", pageSize);
//            model.addAttribute("totalPages", sanPhamPage.getTotalPages());
//            model.addAttribute("employees", nhanVienService.findAll("true"));
//            model.addAttribute("customers", khachHangService.findAll("true"));
//            return "/invoice-update.jsp";
//        } else return "redirect:/invoices/table";
//    }
//
//    @GetMapping("/invoices/cancel")
//    public String cancelOrder(@RequestParam("id") String id) {
//        hoaDonService.cancel(id);
//        return "redirect:/invoices/table";
//    }
//
//}
