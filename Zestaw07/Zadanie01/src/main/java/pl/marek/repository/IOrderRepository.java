package pl.marek.repository;

import pl.marek.model.Order;
import pl.marek.model.OrderEntry;

import java.util.List;

public interface IOrderRepository {

    List<Order> selectAllOrders();

    List<OrderEntry> selectAllEntriesForOrder(String orderId);

    List<Order> selectAllEntriesForUser(String userId);

    int createOrder(Order order);

    int createOrderEntry(OrderEntry orderEntry);

    int deleteOrder(String id);

    int deleteOrdersForUser(String userId);

    int deleteOrderEntriesForOrder(String orderId);
}
