package com.example.QLNonBH.Service;

import com.example.QLNonBH.Entity.SanPham;
import com.example.QLNonBH.Entity.Phanloai;
import com.example.QLNonBH.Exception.ResourceNotFoundException;
import com.example.QLNonBH.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.QLNonBH.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private CategoryRepository categoryRepository; // Inject PhanloaiRepository

    // Lấy danh sách tất cả sản phẩm
    public List<SanPham> getAllSanPhams() {
        return sanPhamRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<SanPham> getSanPhamById(Long id) {
        return sanPhamRepository.findById(id);
    }

    // Tạo sản phẩm mới, bao gồm liên kết với phân loại
    public SanPham createSanPham(SanPham sanPham, Long phanloaiId) {
        // Tìm phân loại theo ID
        Phanloai phanloai = categoryRepository.findById(phanloaiId)
                .orElseThrow(() -> new ResourceNotFoundException("Phân loại không tồn tại"));

        // Gán phân loại cho sản phẩm
        sanPham.setPhanloai(phanloai);
        return sanPhamRepository.save(sanPham);
    }

    // Cập nhật thông tin sản phẩm, bao gồm phân loại
    public SanPham updateSanPham(Long id, SanPham sanPhamDetails, Long phanloaiId) {
        // Lấy sản phẩm từ cơ sở dữ liệu
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại"));

        // Lấy phân loại mới nếu cần thay đổi
        Phanloai phanloai = categoryRepository.findById(phanloaiId)
                .orElseThrow(() -> new ResourceNotFoundException("Phân loại không tồn tại"));

        // Cập nhật thông tin sản phẩm
        sanPham.setTen(sanPhamDetails.getTen());
        sanPham.setGia(sanPhamDetails.getGia());
        sanPham.setMota(sanPhamDetails.getMota());
        sanPham.setSoluong(sanPhamDetails.getSoluong());
        sanPham.setSize(sanPhamDetails.getSize());
        sanPham.setPhanloai(phanloai);  // Cập nhật phân loại mới

        // Cập nhật đường dẫn ảnh nếu có
        if (sanPhamDetails.getAnh() != null) {
            sanPham.setAnh(sanPhamDetails.getAnh());
        }

        return sanPhamRepository.save(sanPham);
    }


    // Xóa sản phẩm
    public void deleteSanPham(Long id) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại"));
        sanPhamRepository.delete(sanPham);
    }
}
