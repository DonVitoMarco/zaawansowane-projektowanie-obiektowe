package pl.marek.service;

import pl.marek.model.Dish;

import java.util.List;

public interface IDishService {

    List<Dish> getDishes();

    Dish getDish(String dishId);

    int createDish(Dish dish);

    int deleteDish(String dishId);

    int updateDish(Dish dishToUpdate);
}
