package com.example.QLNonBH.Service;
import com.example.QLNonBH.Entity.Order;
import com.example.QLNonBH.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Order Items: " + order.getOrderItems()); // Log order items
        }
        return order;
    }
    public Order createOrder(Order order) {
        try {
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());
            return orderRepository.save(order);
        } catch (Exception e) {
            // In ra chi tiết lỗi
            e.printStackTrace();
            return null; // Hoặc xử lý lỗi khác tùy ý
        }
    }


    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setTrangthai(orderDetails.getTrangthai());
            // Cập nhật các trường khác nếu cần
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
