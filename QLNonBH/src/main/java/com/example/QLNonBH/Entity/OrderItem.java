package com.example.QLNonBH.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "CT_donhang")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "donhang_id", nullable = false)
    private Order donhang; // Tham chiếu đến đơn hàng

    private Long sanphamId; // ID sản phẩm
    private String giatien; // Giá tiền
    private String soluong; // Số lượng
    private String tensanpham; // Tên sản phẩm
    private String hinhanh; // Hình ảnh sản phẩm
    private String size; // Kích thước sản phẩm
    private double tongtien; // Tổng tiền

    // Getter và setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và setter cho donhang
    public Order getDonhang() {
        return donhang;
    }

    public void setDonhang(Order donhang) {
        this.donhang = donhang;
    }

    // Getter và setter cho sanphamId
    public Long getSanphamId() {
        return sanphamId;
    }

    public void setSanphamId(Long sanphamId) {
        this.sanphamId = sanphamId;
    }

    // Getter và setter cho giatien
    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    // Getter và setter cho soluong
    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    // Getter và setter cho tensanpham
    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    // Getter và setter cho hinhanh
    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    // Getter và setter cho size
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Getter và setter cho tongtien
    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
}
