package com.example.QLNonBH.Repository;

import com.example.QLNonBH.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface SanPhamRepository extends JpaRepository<SanPham, Long> {

    }

