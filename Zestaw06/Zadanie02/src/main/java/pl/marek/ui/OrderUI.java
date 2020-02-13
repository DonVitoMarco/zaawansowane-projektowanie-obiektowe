package pl.marek.ui;

import pl.marek.model.Dish;
import pl.marek.model.Order;
import pl.marek.model.OrderEntry;
import pl.marek.service.IDishService;
import pl.marek.service.IOrderService;
import pl.marek.util.Parser;
import pl.marek.util.ResultPrinter;

import java.util.Scanner;

public class OrderUI {

    private Scanner scanner;
    private IOrderService orderService;
    private IDishService dishService;

    public OrderUI(Scanner scanner, IOrderService orderService, IDishService dishService) {
        this.scanner = scanner;
        this.orderService = orderService;
        this.dishService = dishService;
    }

    public void showAllOrders() {
        orderService.getOrders().forEach(o -> {
            System.out.println("----------------");
            System.out.printf("Id : %s %n", o.getId());
            System.out.printf("User id : %s %n", o.getUserId());
            System.out.printf("Order Date : %1$td.%1$tm.%1$ty %n", o.getOrderDate());


            orderService.getOrderEntries(o.getId()).forEach(e -> {
                System.out.println("");
                System.out.printf("Id : %s %n", e.getId());
                System.out.printf("Amount : %d %n", e.getAmount());
                System.out.printf("DishName : %s %n", e.getDishName());
                System.out.printf("Price : %.2f %n", e.getPrice());
            });
            System.out.println("----------------");
        });
    }

    public void createOrder() {
        System.out.println("----------------");
        System.out.println("User id: ");
        String userId = scanner.nextLine();
        System.out.println("----------------");

        Order order = new Order(userId);
        int result = orderService.createOrder(order);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");

        String input = "";

        while (!input.equals("0")) {
            System.out.println("1. Create order entry");
            System.out.println("0. Exit");

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Dish id: ");
                    String dishId = scanner.nextLine();
                    System.out.println("Amount: ");
                    String amount = scanner.nextLine();

                    Dish dish = dishService.getDish(dishId);
                    int res = 0;
                    if (dish != null) {
                        OrderEntry orderEntry = new OrderEntry(dish.getName(), order.getId(), dish.getPrice(), Parser.parseInteger(amount));
                        res = orderService.createOrderEntry(order.getId(), orderEntry);
                    }

                    ResultPrinter.printQueryResult(res);

                    break;
                case "0":
                    break;
            }
        }

    }

    public void deleteOrder() {
        System.out.println("----------------");
        System.out.println("Id: ");
        String id = scanner.nextLine();

        int result = orderService.deleteOrder(id);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }
}
