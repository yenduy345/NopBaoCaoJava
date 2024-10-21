package com.example.QLNonBH.Service;

import com.example.QLNonBH.Entity.Phanloai;
import com.example.QLNonBH.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Phanloai> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Phanloai> findById(Integer id) {
        return categoryRepository.findById(Long.valueOf(id));
    }

    public Phanloai save(Phanloai category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(Long.valueOf(id));
    }
}
