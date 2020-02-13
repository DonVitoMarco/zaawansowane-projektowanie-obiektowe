package pl.marek.service;

import org.junit.Before;
import org.junit.Test;
import pl.marek.model.Dish;
import pl.marek.repository.DishRepository;
import pl.marek.repository.IDishRepository;

import java.util.List;

import static org.junit.Assert.*;

public class DishServiceTest {

    private DishService dishService;

    @Before
    public void setUp() {
        IDishRepository dishRepository = new DishInMemoryRepository();
        dishService = new DishService(dishRepository);
    }

    @Test
    public void shouldReturnAll_whenGetAllDishesMethodExecuted() {
        Dish dish = new Dish("Cucumber", 2.00, 100, true);
        Dish secondDish = new Dish("Pickle", 2000.00, 100, true);
        dishService.createDish(dish);
        dishService.createDish(secondDish);

        List<Dish> dishes = dishService.getDishes();

        assertEquals(2, dishes.size());
    }

    @Test
    public void shouldCreateDish_whenCreateDishMethodExecuted() {
        Dish dish = new Dish("Cucumber", 2.00, 100, true);

        dishService.createDish(dish);

        assertEquals(1, dishService.getDishes().size());
    }

    @Test
    public void shouldReturnCorrectDish_whenGetDishMethodExecuted() {
        Dish dish = new Dish("Cucumber", 2.00, 100, true);
        dishService.createDish(dish);

        Dish result = dishService.getDish(dish.getId());

        assertEquals(result.getId(), dish.getId());
    }

    @Test
    public void shouldDeleteDish_whenDishDeleteMethodExecuted() {
        Dish dish = new Dish("Cucumber", 2.00, 100, true);
        dishService.createDish(dish);

        dishService.deleteDish(dish.getId());

        assertEquals(0, dishService.getDishes().size());
    }

    @Test
    public void shouldUpdateDish_whenDishUpdateMethodExecuted() {
        Dish dish = new Dish("Cucumber", 2.00, 100, true);
        dishService.createDish(dish);
        Dish dishToUpdate = new Dish(dish.getId(), "Pickle", dish.getPrice(), dish.getMaxOrders(), dish.isVegan());

        dishService.updateDish(dishToUpdate);

        assertEquals(dishService.getDish(dish.getId()).getName(), dishToUpdate.getName());
    }
}