package pl.marek.service;

import pl.marek.model.Order;
import pl.marek.model.OrderEntry;

import java.util.List;

public interface IOrderService {

    List<Order> getOrders();

    List<OrderEntry> getOrderEntries(String orderId);

    int createOrder(Order order);

    int createOrderEntry(String orderId, OrderEntry orderEntry);

    int deleteOrder(String orderId);
}
