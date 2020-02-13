package pl.marek.service;

import org.junit.Before;
import org.junit.Test;
import pl.marek.model.Order;
import pl.marek.model.OrderEntry;
import pl.marek.repository.IOrderRepository;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void setUp() {
        IOrderRepository orderRepository = new OrderInMemoryRepository();
        this.orderService = new OrderService(orderRepository);
    }

    @Test
    public void shouldCalculateCostForAllDishes_whenCalculateCostMethodExecuted() {
        Order order = new Order("userId");
        OrderEntry orderEntry1 = new OrderEntry("Naan", order.getId(), 20.00, 1);
        OrderEntry orderEntry2 = new OrderEntry("Pad Tai", order.getId(), 10.00, 2);
        orderService.createOrder(order);
        orderService.createOrderEntry(order.getId(), orderEntry1);
        orderService.createOrderEntry(order.getId(), orderEntry2);

        double result = orderService.calculateCost(order);

        assertEquals(40.00, result, 0);
    }
}