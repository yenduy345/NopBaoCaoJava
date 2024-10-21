package com.example.QLNonBH.Controller;
import com.example.QLNonBH.Exception.ResourceNotFoundException;

import com.example.QLNonBH.Entity.SanPham;
import com.example.QLNonBH.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/sanpham")
@CrossOrigin(origins = "http://localhost:4200")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/getAll")
    public List<SanPham> getAllSanPhams() {
        List<SanPham> sanPhams = sanPhamService.getAllSanPhams();
        System.out.println("Danh sách sản phẩm: " + sanPhams); // In danh sách sản phẩm ra console
        return sanPhams;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable Long id) {
        SanPham sanPham = sanPhamService.getSanPhamById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok(sanPham);
    }

    @PostMapping("/create")
    public SanPham createSanPham(@RequestParam("anh") MultipartFile file,
                                 @RequestParam("ten") String ten,
                                 @RequestParam("gia") BigDecimal gia,
                                 @RequestParam("mota") String mota,
                                 @RequestParam("soluong") int soluong,
                                 @RequestParam("size") String size,
                                 @RequestParam("masp") String masp,
                                 @RequestParam("phanloaiId") Long phanloaiId) {
        try {
            // Kiểm tra xem các tham số có hợp lệ không
            if (ten == null || ten.isEmpty() ||
                    gia == null ||
                    mota == null || mota.isEmpty() ||
                    soluong <= 0 ||
                    size == null || size.isEmpty() ||
                    masp == null || masp.isEmpty() ||
                    phanloaiId == null) {
                throw new IllegalArgumentException("Một hoặc nhiều tham số không hợp lệ");
            }

            // Khai báo biến fileName
            String fileName = null;

            // Xử lý file hình ảnh nếu có
            if (file != null && !file.isEmpty()) {
                fileName = file.getOriginalFilename();
                Path filePath = Paths.get("src/main/resources/static/image", fileName);
                Files.write(filePath, file.getBytes());
            }

            // Tạo đối tượng sản phẩm
            SanPham sanPham = new SanPham();
            sanPham.setTen(ten);
            sanPham.setGia(gia);
            sanPham.setMota(mota);
            sanPham.setSoluong(soluong);
            sanPham.setSize(size);
            sanPham.setMasp(masp);

            // Nếu có file thì lưu đường dẫn ảnh, ngược lại đặt giá trị mặc định
            if (fileName != null) {
                sanPham.setAnh("/image/" + fileName); // Lưu đường dẫn ảnh
            } else {
                sanPham.setAnh("/image/default.png"); // Đường dẫn ảnh mặc định nếu không có ảnh tải lên
            }

            // Lưu sản phẩm vào cơ sở dữ liệu, bao gồm phân loại
            return sanPhamService.createSanPham(sanPham, phanloaiId);
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi tham số không hợp lệ
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (IOException e) {
            // Xử lý lỗi khi ghi file
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi khi lưu file: " + e.getMessage());
        } catch (Exception e) {
            // Xử lý lỗi khác
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Có lỗi xảy ra: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable Long id,
                                                 @RequestParam(value = "anh", required = false) MultipartFile file,
                                                 @RequestParam("ten") String ten,
                                                 @RequestParam("gia") BigDecimal gia,
                                                 @RequestParam("mota") String mota,
                                                 @RequestParam("soluong") int soluong,
                                                 @RequestParam("size") String size,
                                                 @RequestParam("masp") String masp,
                                                 @RequestParam("phanloaiId") Long phanloaiId) throws IOException {
        // Lấy sản phẩm từ cơ sở dữ liệu
        SanPham sanPham = sanPhamService.getSanPhamById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại"));

        // Xử lý file hình ảnh nếu có
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get("src/main/resources/static/image", fileName);
            Files.write(filePath, file.getBytes());
            sanPham.setAnh("/image/" + fileName); // Cập nhật đường dẫn ảnh
        }

        // Tạo đối tượng để cập nhật
        SanPham updatedSanPham = new SanPham();
        updatedSanPham.setTen(ten);
        updatedSanPham.setGia(gia);
        updatedSanPham.setMota(mota);
        updatedSanPham.setSoluong(soluong);
        updatedSanPham.setSize(size);
        updatedSanPham.setMasp(masp);

        // Cập nhật sản phẩm trong service
        SanPham result = sanPhamService.updateSanPham(id, updatedSanPham, phanloaiId);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSanPham(@PathVariable Long id) {
        sanPhamService.deleteSanPham(id);
        return ResponseEntity.ok().build();
    }
}


