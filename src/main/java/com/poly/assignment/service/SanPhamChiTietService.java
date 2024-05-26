package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.entity.MauSac;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SanPhamChiTietService {

    List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<>();

    private KichThuocService kichThuocService;

    private MauSacService mauSacService;

    private SanPhamService sanPhamService;

    private @Autowired FileUploadService fileUploadService;
    public SanPhamChiTietService(KichThuocService kichThuocService, MauSacService mauSacService, SanPhamService sanPhamService) {
        this.kichThuocService = kichThuocService;
        this.mauSacService = mauSacService;
        this.sanPhamService = sanPhamService;

        listSanPhamChiTiet.add(new SanPhamChiTiet("1", "SPCT01", "Basic", kichThuocService.findById("1"), mauSacService.findById("1"), sanPhamService.findById("1"), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("2", "SPCT02", "Kẻ sọc", kichThuocService.findById("2"), mauSacService.findById("2"), sanPhamService.findById("2"), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("3", "SPCT03", "Tay ngắn", kichThuocService.findById("3"), mauSacService.findById("3"), sanPhamService.findById("3"), 15, 150.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("4", "SPCT04", "Caro", kichThuocService.findById("4"), mauSacService.findById("4"), sanPhamService.findById("4"), 15, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("5", "SPCT05", "Caro", kichThuocService.findById("5"), mauSacService.findById("5"), sanPhamService.findById("5"), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("6", "SPCT06", "Kẻ sọc", kichThuocService.findById("6"), mauSacService.findById("6"), sanPhamService.findById("6"), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("7", "SPCT07", "Caro",  kichThuocService.findById("7"), mauSacService.findById("7"), sanPhamService.findById("7"), 15, 200.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
    }

    public List<SanPhamChiTiet> findAll(String status) {
        if (status.equals("true")) return listSanPhamChiTiet.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listSanPhamChiTiet.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listSanPhamChiTiet;
    }

    public SanPhamChiTiet findById(String id) {
        return listSanPhamChiTiet.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);
    }

    public List<SanPhamChiTiet> findAllSanPhamChiTietBySanPhamId(String id) {
        return listSanPhamChiTiet.stream()
                .filter(spct -> spct.getSanPham().getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<SanPhamChiTiet> findByKey(String key) {
        List<SanPhamChiTiet> result = new ArrayList<>();
        for (SanPhamChiTiet sanPhamChiTiet : listSanPhamChiTiet) {
            if (sanPhamChiTiet.getMaSPCT().contains(key) ||
                    sanPhamChiTiet.getMauSac().getTen().contains(key) ||
                    sanPhamChiTiet.getKichThuoc().getTen().contains(key) ||
                    sanPhamChiTiet.getSanPham().getMaSP().contains(key) ||
                    sanPhamChiTiet.getSanPham().getTen().contains(key)) {
                result.add(sanPhamChiTiet);
            }
        }

        return result;
    }

    public void create(SanPhamChiTiet sanPhamChiTiet, String pid, MultipartFile file) throws IOException {
        sanPhamChiTiet.setId(UUID.randomUUID().toString());
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(pid));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        listSanPhamChiTiet.add(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet, String pid, MultipartFile file) throws IOException {
        for (int i = 0; i < listSanPhamChiTiet.size(); i++) {
            if (listSanPhamChiTiet.get(i).getId().equals(sanPhamChiTiet.getId())) {
                sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
                sanPhamChiTiet.setSanPham(sanPhamService.findById(pid));
                sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
                sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
                listSanPhamChiTiet.set(i, sanPhamChiTiet);
            }
        }
    }

    public void delete(String id) {
        listSanPhamChiTiet.remove(findById(id));
    }

}
