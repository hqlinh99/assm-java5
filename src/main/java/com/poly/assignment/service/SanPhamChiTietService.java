package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.entity.MauSac;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamChiTietService {

    List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<>();

    public SanPhamChiTietService() {
        listSanPhamChiTiet.add(new SanPhamChiTiet("1", "SPCT01", "Basic", new KichThuoc("1", "KT01", "S", true), new MauSac("1", "MS01", "Den", true), new SanPham("1", "SP01", "Ao so mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("2", "SPCT02", "Kẻ sọc", new KichThuoc("2", "KT02", "M", true), new MauSac("3", "MS03", "Do", true), new SanPham("3", "SP03", "Ao hoodie", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("3", "SPCT03", "Tay ngắn", new KichThuoc("3", "KT03", "L", true), new MauSac("2", "MS02", "Trang", true), new SanPham("4", "SP04", "Ao polo", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true), 15, 150.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("4", "SPCT04", "Caro", new KichThuoc("4", "KT04", "XL", true), new MauSac("4", "MS04", "Xanh", true), new SanPham("1", "SP01", "Ao so mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true), 15, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("5", "SPCT05", "Caro", new KichThuoc("5", "KT05", "XXL", true), new MauSac("5", "MS05", "Cam", true), new SanPham("4", "SP04", "Ao polo", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("6", "SPCT06", "Kẻ sọc", new KichThuoc("2", "KT02", "M", true), new MauSac("3", "MS03", "Do", true), new SanPham("2", "SP02", "Ao khoac", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPhamChiTiet.add(new SanPhamChiTiet("7", "SPCT07", "Caro", new KichThuoc("4", "KT04", "XL", true), new MauSac("4", "MS04", "Xanh", true), new SanPham("5", "SP05", "Ao ni", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true), 15, 200.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
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

    public void create(SanPhamChiTiet sanPhamChiTiet) {
        listSanPhamChiTiet.add(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet) {
        for (int i = 0; i < listSanPhamChiTiet.size(); i++) {
            if (listSanPhamChiTiet.get(i).getId().equals(sanPhamChiTiet.getId())) {
                listSanPhamChiTiet.set(i, sanPhamChiTiet);
            }
        }
    }

    public void delete(String id) {
        List<SanPhamChiTiet> deList = new ArrayList<>();
        for (int i = 0; i < listSanPhamChiTiet.size(); i++) {
            if (listSanPhamChiTiet.get(i).getId().equals(id)) {
                deList.add(listSanPhamChiTiet.get(i));
            }
        }

        listSanPhamChiTiet.removeAll(deList);
    }

}
