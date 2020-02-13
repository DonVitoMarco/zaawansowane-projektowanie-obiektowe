package pl.marek.repository;

import pl.marek.model.Dish;

import java.util.List;

public interface IDishRepository {

    Dish selectDish(String userId);

    List<Dish> selectAllDishes();

    int createDish(Dish dish);

    int deleteDish(String id);

    int changeDish(Dish dish);
}
