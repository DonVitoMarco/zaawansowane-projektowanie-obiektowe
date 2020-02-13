package pl.marek.ui;

import pl.marek.model.Dish;
import pl.marek.service.IDishService;
import pl.marek.util.Parser;
import pl.marek.util.ResultPrinter;

import java.util.Scanner;

public class DishUI {

    private Scanner scanner;
    private IDishService dishService;

    public DishUI(Scanner scanner, IDishService dishService) {
        this.dishService = dishService;
        this.scanner = scanner;
    }

    public void showAllDishes() {
        dishService.getDishes().forEach(d -> {
            System.out.println("----------------");
            System.out.printf("Id : %s %n", d.getId());
            System.out.printf("Name : %s %n", d.getName());
            System.out.printf("Price : %.2f %n", d.getPrice());
            System.out.printf("Max Orders : %d %n", d.getMaxOrders());
            System.out.printf("Vegan : %b %n", d.isVegan());
            System.out.println("----------------");
        });
    }

    public void createDish() {
        System.out.println("----------------");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Price: ");
        String price = scanner.nextLine();
        System.out.println("Max Orders: ");
        String maxOrders = scanner.nextLine();
        System.out.println("Vegan: ");
        String vegan = scanner.nextLine();
        System.out.println("----------------");

        Dish dish = new Dish(name, Parser.parseDouble(price), Parser.parseInteger(maxOrders), Parser.parseBoolean(vegan));
        int result = dishService.createDish(dish);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }

    public void deleteDish() {
        System.out.println("----------------");
        System.out.println("Id: ");
        String id = scanner.nextLine();

        int result = dishService.deleteDish(id);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }

    public void updateDish() {
        System.out.println("----------------");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Price: ");
        String price = scanner.nextLine();
        System.out.println("Max Orders: ");
        String maxOrders = scanner.nextLine();
        System.out.println("Vegan: ");
        String vegan = scanner.nextLine();

        Dish dish = new Dish(id, name, Parser.parseDouble(price), Parser.parseInteger(maxOrders), Parser.parseBoolean(vegan));
        int result = dishService.updateDish(dish);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }
}
