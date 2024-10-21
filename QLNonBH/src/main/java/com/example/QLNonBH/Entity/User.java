package com.example.QLNonBH.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "nguoidung")  // Tên bảng là "nguoidung"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID tự động tăng
    private Integer id;

    @Column(name = "tennguoidung", nullable = false, unique = true)  // Cột "tennguoidung"
    private String username;

    @Column(name = "matkhau", nullable = false)  // Cột "matkhau"
    private String password;

    @Column(name = "Email", nullable = false, unique = true)  // Cột "Email"
    private String email;

    @Column(name = "description", nullable = false, columnDefinition = "SMALLINT DEFAULT 0 CHECK (description IN (0, 1))")  // Cột "description"
    private Short description;

    @Column(name = "created_at", updatable = false)  // Cột "created_at"
    private Timestamp createdAt;

    @Column(name = "updated_at")  // Cột "updated_at"
    private Timestamp updatedAt;

    // Constructors
    public User() {}

    public User(String username, String password, String email, Short description) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getDescription() {
        return description;
    }

    public void setDescription(Short description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
