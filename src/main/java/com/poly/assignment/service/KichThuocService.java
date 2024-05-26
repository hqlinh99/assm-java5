package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KichThuocService {

    List<KichThuoc> listKichThuoc = new ArrayList<>();

    public KichThuocService() {
        listKichThuoc.add(new KichThuoc("1", "KT01", "S", true));
        listKichThuoc.add(new KichThuoc("2", "KT02", "M", true));
        listKichThuoc.add(new KichThuoc("3", "KT03", "L", true));
        listKichThuoc.add(new KichThuoc("4", "KT04", "XL", true));
        listKichThuoc.add(new KichThuoc("5", "KT05", "XXL", true));
    }

    public List<KichThuoc> findAll(String status) {
        if (status.equals("true")) return listKichThuoc.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listKichThuoc.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listKichThuoc;
    }

    public KichThuoc findById(String id) {
        for (KichThuoc kichThuoc: listKichThuoc) {
            if (kichThuoc.getId().equals(id)) {
                return kichThuoc;
            }
        }

        return null;
    }

    public List<KichThuoc> findByKey(String key) {
        List<KichThuoc> result = new ArrayList<>();
        for (KichThuoc kichThuoc: listKichThuoc) {
            if (kichThuoc.getMaKT().contains(key) || kichThuoc.getTen().contains(key)) {
                result.add(kichThuoc);
            }
        }

        return result;
    }

    public void create(KichThuoc kichThuoc) {
        kichThuoc.setId(UUID.randomUUID().toString());
        listKichThuoc.add(kichThuoc);
    }

    public void update(KichThuoc kichThuoc) {
        for (int i = 0; i < listKichThuoc.size(); i++) {
            if (listKichThuoc.get(i).getId().equals(kichThuoc.getId())) {
                listKichThuoc.set(i, kichThuoc);
            }
        }
    }

    public void delete(String id) {
        List<KichThuoc> deList = new ArrayList<>();
        for (int i = 0; i < listKichThuoc.size(); i++) {
            if (listKichThuoc.get(i).getId().equals(id)) {
                deList.add(listKichThuoc.get(i));
            }
        }

        listKichThuoc.removeAll(deList);
    }

}
