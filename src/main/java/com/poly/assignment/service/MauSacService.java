package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MauSacService {

    List<MauSac> listMauSac = new ArrayList<>();

    public MauSacService() {
        listMauSac.add(new MauSac("1", "MS01", "Den", true));
        listMauSac.add(new MauSac("2", "MS02", "Trang", true));
        listMauSac.add(new MauSac("3", "MS03", "Do", true));
        listMauSac.add(new MauSac("4", "MS04", "Xanh", true));
        listMauSac.add(new MauSac("5", "MS05", "Cam", true));
    }

    public List<MauSac> findAll(String status) {
        if (status.equals("true")) return listMauSac.stream()
                .filter(item -> item.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listMauSac.stream()
                .filter(item -> !item.getTrangThai())
                .collect(Collectors.toList());
        return listMauSac;
    }

    public MauSac findById(String id) {
        return listMauSac.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public List<MauSac> findByKey(String key) {
        return listMauSac.stream()
                .filter(item -> item.getMaMS().contains(key) || item.getTen().contains(key))
                .collect(Collectors.toList());
    }

    public void create(MauSac mauSac) throws IOException {
        mauSac.setId(UUID.randomUUID().toString());
        listMauSac.add(mauSac);
    }

    public void update(MauSac mauSac) throws IOException {
        for (int i = 0; i < listMauSac.size(); i++) {
            if (listMauSac.get(i).getId().equals(mauSac.getId())) {
                listMauSac.set(i, mauSac);
            }
        }
    }

    public void delete(String id) {
        listMauSac.remove(findById(id));
    }

}
