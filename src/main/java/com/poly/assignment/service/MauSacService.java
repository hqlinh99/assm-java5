package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listMauSac.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listMauSac;
    }

    public MauSac findById(String id) {
        for (MauSac mauSac: listMauSac) {
            if (mauSac.getId().equals(id)) {
                return mauSac;
            }
        }

        return null;
    }

    public List<MauSac> findByKey(String key) {
        List<MauSac> result = new ArrayList<>();
        for (MauSac mauSac: listMauSac) {
            if (mauSac.getMaMS().contains(key) || mauSac.getTen().contains(key)) {
                result.add(mauSac);
            }
        }

        return result;
    }

    public void create(MauSac mauSac) {
        mauSac.setId(UUID.randomUUID().toString());
        listMauSac.add(mauSac);
    }

    public void update(MauSac mauSac) {
        for (int i = 0; i < listMauSac.size(); i++) {
            if (listMauSac.get(i).getId().equals(mauSac.getId())) {
                listMauSac.set(i, mauSac);
            }
        }
    }

    public void delete(String id) {
        List<MauSac> deList = new ArrayList<>();
        for (int i = 0; i < listMauSac.size(); i++) {
            if (listMauSac.get(i).getId().equals(id)) {
                deList.add(listMauSac.get(i));
            }
        }

        listMauSac.removeAll(deList);
    }

}
