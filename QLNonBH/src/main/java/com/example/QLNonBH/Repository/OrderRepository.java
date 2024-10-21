package com.example.QLNonBH.Repository;

import com.example.QLNonBH.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
