package com.example.QLNonBH.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "donhang")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID của đơn hàng

    private String ten; // Tên khách hàng
    private String lastName; // Họ khách hàng
    private String diachi; // Địa chỉ
    private String sodienthoai; // Số điện thoại
    private String email; // Email

    @Column(name = "trangthai")
    private String trangthai; // Trạng thái đơn hàng

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // Thời gian tạo đơn hàng

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Thời gian cập nhật đơn hàng

    @OneToMany(mappedBy = "donhang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems; // Danh sách chi tiết sản phẩm trong đơn hàng

    // Getter và setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và setter cho tên
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    // Getter và setter cho họ
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter và setter cho địa chỉ
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    // Getter và setter cho số điện thoại
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    // Getter và setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và setter cho trạng thái
    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    // Getter cho thời gian tạo
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Getter và setter cho thời gian cập nhật
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getter và setter cho orderItems
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
