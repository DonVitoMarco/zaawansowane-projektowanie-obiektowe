package pl.marek;

import pl.marek.repository.*;
import pl.marek.service.AccountService;
import pl.marek.service.DishService;
import pl.marek.service.OrderService;
import pl.marek.ui.DishUI;
import pl.marek.ui.OrderUI;
import pl.marek.ui.UserUI;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        IAccountRepository accountRepository = new AccountRepository();
        IDishRepository dishRepository = new DishRepository();
        IOrderRepository orderRepository = new OrderRepository();

        AccountService accountService = new AccountService(accountRepository, orderRepository);
        DishService dishService = new DishService(dishRepository);
        OrderService orderService = new OrderService(orderRepository);

        UserUI userUI = new UserUI(in, accountService);
        DishUI dishUI = new DishUI(in, dishService);
        OrderUI orderUI = new OrderUI(in, orderService, dishService);
        String input = "";

        while (!input.equals("0")) {
            System.out.println("=== CRUD APPLICATION ===");
            System.out.println("1. Show all users");
            System.out.println("2. Create user");
            System.out.println("3. Delete user");
            System.out.println("4. Update password");
            System.out.println("5. Update address");
            System.out.println("6. Show all dishes");
            System.out.println("7. Create dish");
            System.out.println("8. Delete dish");
            System.out.println("9. Update dish");
            System.out.println("10. Show all orders");
            System.out.println("11. Create order");
            System.out.println("12. Delete order");
            System.out.println("0. Exit \n");

            input = in.nextLine();
            switch (input) {
                case "1":
                    userUI.showAllUsers();
                    break;
                case "2":
                    userUI.createUser();
                    break;
                case "3":
                    userUI.deleteUser();
                    break;
                case "4":
                    userUI.updatePassword();
                    break;
                case "5":
                    userUI.updateAddress();
                    break;
                case "6":
                    dishUI.showAllDishes();
                    break;
                case "7":
                    dishUI.createDish();
                    break;
                case "8":
                    dishUI.deleteDish();
                    break;
                case "9":
                    dishUI.updateDish();
                    break;
                case "10":
                    orderUI.showAllOrders();
                    break;
                case "11":
                    orderUI.createOrder();
                    break;
                case "12":
                    orderUI.deleteOrder();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("No option");
            }
        }

    }
}
