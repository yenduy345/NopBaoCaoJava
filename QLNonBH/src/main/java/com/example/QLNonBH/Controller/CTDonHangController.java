package com.example.QLNonBH.Controller;

import com.example.QLNonBH.Entity.OrderItem;
import com.example.QLNonBH.Service.CTDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/donhang")
public class CTDonHangController {
    @Autowired
    private CTDonHangService ctDonHangService;

    @GetMapping("/{id}/chitiet")
    public List<OrderItem> getCTDonHang(@PathVariable Long id) {
        return ctDonHangService.getCTDonHangByDonHangId(id);
    }
}
