package com.example.QLNonBH.Repository;

import com.example.QLNonBH.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemReposiory  extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByDonhangId(Long orderId);
}
