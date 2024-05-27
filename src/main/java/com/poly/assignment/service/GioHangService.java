package com.poly.assignment.service;

import com.poly.assignment.entity.GioHang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GioHangService {

    List<GioHang> gioHangList = new ArrayList<>();

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

    public void addToCart(GioHang gioHang) {
        GioHang gioHangResult = findByProductDetailId(gioHang.getSanPhamChiTiet().getId());
        if (gioHangResult != null) {
            gioHangResult.setQuantity(gioHangResult.getQuantity() + 1);
        } else gioHangList.add(gioHang);
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
