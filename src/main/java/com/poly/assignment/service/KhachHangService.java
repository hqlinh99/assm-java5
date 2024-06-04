package com.poly.assignment.service;

import com.poly.assignment.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KhachHangService {

    List<KhachHang> listKhachHang = new ArrayList<>();

    public KhachHangService() {
        listKhachHang.add(new KhachHang("1", "KH01", "Luu Thi Hai Yen", "0345674567", true));
        listKhachHang.add(new KhachHang("2", "KH02", "Hoang Quang Linh", "0312341234", true));
        listKhachHang.add(new KhachHang("3", "KH03", "Do Thi Hong Khanh", "0987654321", true));
        listKhachHang.add(new KhachHang("4", "KH04", "Luu Thi Hai Yen", "0323452345", true));
        listKhachHang.add(new KhachHang("5", "KH05", "Nguyen Thi Bich Le", "0956781234", true));
        listKhachHang.add(new KhachHang("6", "KH06", "Luu Thi Mai Huong", "0956781234", false));
        listKhachHang.add(new KhachHang("7", "KH07", "Luu Manh Duy", "0956781234", true));
        listKhachHang.add(new KhachHang("8", "KH08", "Le Thi Thu Hai", "0956781234", false));
        listKhachHang.add(new KhachHang("9", "KH09", "Nguyen Thi Bich Hang", "0956781234", false));
        listKhachHang.add(new KhachHang("10", "KH010", "Luu Van Thanh", "0956781234", true));
    }

    public List<KhachHang> findAll(String status) {
        if (status.equals("true")) return listKhachHang.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listKhachHang.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listKhachHang;
    }

    public KhachHang findById(String id) {
        return listKhachHang.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);

    }

    public List<KhachHang> findByKey(String key) {
        return listKhachHang.stream()
                .filter(sp -> sp.getMaKH().contains(key)
                        || sp.getTen().contains(key)
                        || sp.getSdt().contains(key))
                .collect(Collectors.toList());
    }

    public void create(KhachHang khachHang) {
        khachHang.setId(UUID.randomUUID().toString());
        listKhachHang.add(khachHang);
    }

    public void update(KhachHang khachHang) {
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getId().equals(khachHang.getId())) {
                listKhachHang.set(i, khachHang);
            }
        }
    }

    public void delete(String id) {
        listKhachHang.remove(findById(id));
    }

}
