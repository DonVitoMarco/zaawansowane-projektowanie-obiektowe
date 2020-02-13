package pl.marek.service;

import pl.marek.model.Dish;
import pl.marek.repository.IDishRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DishInMemoryRepository implements IDishRepository {

    private ConcurrentHashMap<String, Dish> storage = new ConcurrentHashMap<>();

    @Override
    public Dish selectDish(String dishId) {
        return storage.get(dishId);
    }

    @Override
    public List<Dish> selectAllDishes() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int createDish(Dish dish) {
        storage.put(dish.getId(), dish);
        return 1;
    }

    @Override
    public int deleteDish(String id) {
        storage.remove(id);
        return 1;
    }

    @Override
    public int changeDish(Dish dish) {
        storage.put(dish.getId(), dish);
        return 1;
    }
}
