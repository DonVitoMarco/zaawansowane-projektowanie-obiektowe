package pl.marek.service;

import pl.marek.model.Order;
import pl.marek.model.OrderEntry;
import pl.marek.repository.IOrderRepository;

import java.util.List;

public class OrderService implements IOrderService {

    private IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.selectAllOrders();
    }

    public List<OrderEntry> getOrderEntries(String orderId) {
        return orderRepository.selectAllEntriesForOrder(orderId);
    }

    public int createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    public int createOrderEntry(String orderId, OrderEntry orderEntry) {
        return orderRepository.createOrderEntry(orderEntry);
    }

    public int deleteOrder(String orderId) {
        int firstResult = orderRepository.deleteOrderEntriesForOrder(orderId);
        int secondResult = orderRepository.deleteOrder(orderId);

        return firstResult + secondResult >= 1 ? 1 : 0;
    }
}
