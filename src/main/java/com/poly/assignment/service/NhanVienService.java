package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NhanVienService {

    List<NhanVien> listNhanVien = new ArrayList<>();

    private @Autowired
    FileUploadService fileUploadService;

    public NhanVienService() {
        listNhanVien.add(new NhanVien("1", "http://localhost:9999/public/upload/z5223556709680_9ca0158bc8d301450ed2199279d27d1e.jpg", "NV01", "Nguyen Van A", "a12345", "123456", true, true));
        listNhanVien.add(new NhanVien("2", null, "NV02", "Nguyen Thi B", "b12345", "123456", false, true));
        listNhanVien.add(new NhanVien("3", null, "NV03", "Nguyen Van C", "c12345", "123456", false, true));
        listNhanVien.add(new NhanVien("4", null, "NV04", "Nguyen Thi D", "d12345", "123456", false, true));
        listNhanVien.add(new NhanVien("5", null, "NV05", "Nguyen Van E", "e12345", "123456", false, true));
        listNhanVien.add(new NhanVien("6", null, "NV06", "Nguyen Van F", "f12345", "123456", false, false));
        listNhanVien.add(new NhanVien("7", null, "NV07", "Nguyen Van G", "g12345", "123456", false, true));
        listNhanVien.add(new NhanVien("8", null, "NV08", "Nguyen Van H", "h12345", "123456", false, false));
        listNhanVien.add(new NhanVien("9", null, "NV09", "Nguyen Van I", "i12345", "123456", false, true));
    }

    public List<NhanVien> findAll(String status) {
        if (status.equals("true")) return listNhanVien.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listNhanVien.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listNhanVien;
    }

    public NhanVien findById(String id) {
        return listNhanVien.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);
    }

    public NhanVien findByUsername(String username) {
        return listNhanVien.stream().filter(sp -> sp.getTenDangNhap().equals(username)).findFirst().orElse(null);
    }

    public List<NhanVien> findByKey(String key) {
        return listNhanVien.stream()
                .filter(e -> e.getMaNV().contains(key)
                        || e.getTen().contains(key)
                        || e.getTenDangNhap().contains(key))
                .collect(Collectors.toList());
    }

    public void create(NhanVien nhanVien, MultipartFile file) throws IOException {
        nhanVien.setId(UUID.randomUUID().toString());
        nhanVien.setHinhAnh(fileUploadService.uploadFile(file));
        listNhanVien.add(nhanVien);
    }

    public void update(NhanVien nhanVien, MultipartFile file) throws IOException {
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getId().equals(nhanVien.getId())) {
                String anh = fileUploadService.uploadFile(file);
                if (anh != null)
                    nhanVien.setHinhAnh(anh);
                else nhanVien.setHinhAnh(listNhanVien.get(i).getHinhAnh());
                listNhanVien.set(i, nhanVien);
            }
        }
    }

    public void delete(String id) {
        listNhanVien.remove(findById(id));
    }

}
