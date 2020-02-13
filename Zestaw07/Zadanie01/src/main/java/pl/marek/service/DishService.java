package pl.marek.service;

import pl.marek.model.Dish;
import pl.marek.repository.IDishRepository;

import java.util.List;

public class DishService implements IDishService {

    private IDishRepository dishRepository;

    public DishService(IDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getDishes() {
        return dishRepository.selectAllDishes();
    }

    public Dish getDish(String dishId) {
        return dishRepository.selectDish(dishId);
    }

    public int createDish(Dish dish) {
        return dishRepository.createDish(dish);
    }

    public int deleteDish(String dishId) {
        return dishRepository.deleteDish(dishId);
    }

    public int updateDish(Dish dishToUpdate) {
        return dishRepository.changeDish(dishToUpdate);
    }
}
