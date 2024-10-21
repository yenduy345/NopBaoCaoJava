package com.example.QLNonBH.Repository;

import com.example.QLNonBH.Entity.Phanloai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Phanloai, Long> {
}
