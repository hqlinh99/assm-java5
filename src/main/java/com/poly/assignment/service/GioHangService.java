package com.poly.assignment.service;

import com.poly.assignment.entity.GioHang;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.ISanPhamChiTietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GioHangService {


    List<GioHang> gioHangList = new ArrayList<>();
    private final SanPhamChiTietService sanPhamChiTietService;


    public List<GioHang> findAll() {
        return gioHangList;
    }

    public GioHang findById(List<GioHang> gioHangList, String cid) {
        return gioHangList.stream()
                .filter(item -> item.getId().equals(cid))
                .findFirst().orElse(null);
    }

    public GioHang findByProductDetailId(String pdid) {
        return gioHangList.stream()
                .filter(item -> item.getSanPhamChiTiet().getId().equals(pdid))
                .findFirst().orElse(null);
    }

    public void addToCart(String pdid) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findById(pdid);

        GioHang gioHangResult = findByProductDetailId(sanPhamChiTiet.getId());
        if (gioHangResult != null) {
            gioHangResult.setQuantity(gioHangResult.getQuantity() + 1);
        } else {
            GioHang gioHang = new GioHang();
            gioHang.setId(UUID.randomUUID().toString().substring(6));
            gioHang.setSanPhamChiTiet(sanPhamChiTiet);
            gioHang.setQuantity(1);
            gioHangList.add(gioHang);
        }
    }

    public void decreaseQuantityInCart(String cid) {
        GioHang gioHang = findById(gioHangList, cid);
        if (gioHang != null)
            gioHang.setQuantity(gioHang.getQuantity() - 1);
    }

    public void increaseQuantityInCart(String cid) {
        GioHang gioHang = findById(gioHangList, cid);
        if (gioHang != null)
            gioHang.setQuantity(gioHang.getQuantity() + 1);
    }

    public void deleteItemInCart(String pdid) {
        GioHang gioHangResult = findByProductDetailId(pdid);
        if (gioHangResult != null)
            gioHangList.remove(gioHangResult);
    }

    public double getTongTien()
    {
        return gioHangList.stream().mapToDouble(item -> item.getSanPhamChiTiet().getDonGia() * item.getQuantity()).sum();
    }

    public void deleteAll() {
        gioHangList.removeAll(gioHangList);
    }

}
