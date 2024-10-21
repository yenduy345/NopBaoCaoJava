package com.example.QLNonBH.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phanloai")  // Tên bảng là "phanloai"
public class Phanloai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID tự động tăng
    private Integer id;

    @Column(name = "phanloai_name", nullable = false)  // Cột "phanloai_name"
    private String phanloaiName;

    // Constructors
    public Phanloai() {}

    public Phanloai(String phanloaiName) {
        this.phanloaiName = phanloaiName;
    }

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhanloaiName() {
        return phanloaiName;
    }

    public void setPhanloaiName(String phanloaiName) {
        this.phanloaiName = phanloaiName;
    }
}
