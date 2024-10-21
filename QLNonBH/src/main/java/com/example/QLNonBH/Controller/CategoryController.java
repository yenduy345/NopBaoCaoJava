package com.example.QLNonBH.Controller;

import com.example.QLNonBH.Entity.Phanloai;
import com.example.QLNonBH.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})  // Cho phép CORS từ các nguồn frontend
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Phanloai> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Phanloai> getCategoryById(@PathVariable Integer id) {
        Optional<Phanloai> category = categoryService.findById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Phanloai createCategory(@RequestBody Phanloai category) {
        return categoryService.save(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Phanloai> updateCategory(@PathVariable Integer id, @RequestBody Phanloai category) {
        if (categoryService.findById(id).isPresent()) {
            category.setId(id);
            return ResponseEntity.ok(categoryService.save(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        if (categoryService.findById(id).isPresent()) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
