package com.example.QLNonBH.Service;

import com.example.QLNonBH.Entity.OrderItem;
import com.example.QLNonBH.Repository.OrderItemReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTDonHangService {
    @Autowired
    private OrderItemReposiory ctDonhangRepository;

    public List<OrderItem> getCTDonHangByDonHangId(Long donHangId) {
        return ctDonhangRepository.findByDonhangId(donHangId); // Gọi phương thức trong Repository
    }
}
