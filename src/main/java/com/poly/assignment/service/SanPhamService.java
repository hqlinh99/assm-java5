package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.util.PageUtil;
import lombok.RequiredArgsConstructor;
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
public class SanPhamService {

    List<SanPham> listSanPham = new ArrayList<>();

    private @Autowired
    FileUploadService fileUploadService;


    public SanPhamService() {
        listSanPham.add(new SanPham("1", "SP01", "Áo sơ mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("2", "SP02", "Áo khoác", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("3", "SP03", "Áo hoodie", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("4", "SP04", "Áo polo", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("5", "SP05", "Áo nỉ", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("6", "SP06", "Áo phông", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("7", "SP07", "Áo thun", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("8", "SP08", "Áo vest", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", false));
        listSanPham.add(new SanPham("9", "SP09", "Áo sơ mi tay dài", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("10", "SP010", "Áo blazer", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
    }

    public List<SanPham> findAll(String status) {
        if (status.equals("true")) return listSanPham.stream()
                .filter(sp -> sp.getTrangThai())
                .collect(Collectors.toList());
        if (status.equals("false")) return listSanPham.stream()
                .filter(sp -> !sp.getTrangThai())
                .collect(Collectors.toList());
        return listSanPham;
    }

    public SanPham findById(String id) {
        return listSanPham.stream().filter(sp -> sp.getId().equals(id)).findFirst().orElse(null);
    }

    public List<SanPham> findByKey(String key) {
        return listSanPham.stream()
                .filter(sp -> sp.getMaSP().contains(key) || sp.getTen().contains(key))
                .collect(Collectors.toList());
    }

    public void create(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setId(UUID.randomUUID().toString());
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        listSanPham.add(sanPham);
    }

    public void update(SanPham sanPham, MultipartFile file) throws IOException {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getId().equals(sanPham.getId())) {
                sanPham.setHinhAnh(fileUploadService.uploadFile(file));
                listSanPham.set(i, sanPham);
            }
        }
    }

    public void delete(String id) {
        listSanPham.remove(findById(id));
    }

}
