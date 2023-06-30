package com.oliveira.digitalmenu.food;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jonathan_oliveira
 */
@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodsDAO;
    
    public Food addFood(Food food) {
        return foodsDAO.save(food);
    }
    
    public List<Food> getFoods() {
        return foodsDAO.findAll();
    }

    public Optional<Food> getFood(Long id) {
        return foodsDAO.findById(id);
    }
    
    public void deleteFood(Optional<Food> food){
        foodsDAO.delete(food.get());
    }
}
