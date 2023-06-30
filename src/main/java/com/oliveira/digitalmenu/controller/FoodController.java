package com.oliveira.digitalmenu.controller;

import com.oliveira.digitalmenu.food.Food;
import com.oliveira.digitalmenu.food.FoodService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Backend = Tabela no BD PostgreSQ + Controller + Model
 * Frontend = React e Typescript
 * 
 * @author jonathan_oliveira
 */
@RestController
@RequestMapping("foods")
public class FoodController {
    
    private FoodService foodsService;
    
   // default e o serviço fica null
    public FoodController(FoodService foodService) {
            super();
            this.foodsService = foodService;
    }

    // Configuração do Cross, conectando API com o FRONT
    // Algumas vezes os Browsers fazem verificações e pode ocorrer perdas
    // neste caso o * esta permitindo tudo
    // pode colocar no lugar o lugar e porta,
    // quando subir para produção se restringe sómente ao domínio para deixar mais seguro
    // Save New Food 
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping //(@Valid)
    public ResponseEntity<Food> saveFood(@RequestBody Food food) {
            return new ResponseEntity<Food>(foodsService.addFood(food), HttpStatus.CREATED);
    }
    
    //Get Foods  by id
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
            Optional<Food> food = foodsService.getFood(id);
            if (food.isPresent())
            return new ResponseEntity<Food>(food.get(), HttpStatus.OK);
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
    }

    //Get All Foods 
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Food>> getFoods() {             
            return new ResponseEntity<List<Food>>(foodsService.getFoods(), HttpStatus.OK);
    }
    

    //Delete food by id
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteFood(@PathVariable(value = "id") Long id) throws Throwable {
                
        Optional<Food> food = foodsService.getFood(id);
                //-> new Exception("Food not found for this id :: " + id));

        foodsService.deleteFood(food);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    //Update Food total by id
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable(value = "id") Long id, 
        @RequestBody Food foodDetails) throws Exception {
        @Valid
        Food food = foodsService.getFood(id).orElseThrow(() 
                -> new Exception("Food not found for this id :: " + id));

        food.setTitle(foodDetails.getTitle());
        food.setImage(foodDetails.getImage());
        food.setPrice(foodDetails.getPrice());
        final Food updateFood = foodsService.addFood(food);
        return ResponseEntity.ok(updateFood);
    }
    
    //Update Food partially
    @PatchMapping("/{id}/{title}")
    public ResponseEntity<Food> updateFoodPartially(@PathVariable Long id, @PathVariable String title) {
	try {
		Food food = foodsService.getFood(id).get(); 
		food.setTitle(title);
		return new ResponseEntity<Food>(  
                        foodsService.addFood(food), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
    
}
