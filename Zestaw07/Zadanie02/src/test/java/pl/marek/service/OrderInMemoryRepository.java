package pl.marek.service;

import pl.marek.model.Order;
import pl.marek.model.OrderEntry;
import pl.marek.repository.IOrderRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class OrderInMemoryRepository implements IOrderRepository {

    private ConcurrentHashMap<String, Order> storageOrder = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, OrderEntry> storageOrderEntry = new ConcurrentHashMap<>();

    @Override
    public List<Order> selectAllOrders() {
        return new ArrayList<>(storageOrder.values());
    }

    @Override
    public List<OrderEntry> selectAllEntriesForOrder(String orderId) {
        return storageOrderEntry.values().stream().filter(s -> s.getOrderId().equals(orderId)).collect(Collectors.toList());
    }

    @Override
    public List<Order> selectAllEntriesForUser(String userId) {
        throw new NotImplementedException();
    }

    @Override
    public int createOrder(Order order) {
        storageOrder.put(order.getId(), order);
        return 1;
    }

    @Override
    public int createOrderEntry(OrderEntry orderEntry) {
        storageOrderEntry.put(orderEntry.getId(), orderEntry);
        return 1;
    }

    @Override
    public int deleteOrder(String id) {
        throw new NotImplementedException();
    }

    @Override
    public int deleteOrdersForUser(String userId) {
        throw new NotImplementedException();
    }

    @Override
    public int deleteOrderEntriesForOrder(String orderId) {
        throw new NotImplementedException();
    }
}
