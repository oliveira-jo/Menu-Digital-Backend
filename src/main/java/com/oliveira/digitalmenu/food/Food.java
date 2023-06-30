package com.oliveira.digitalmenu.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jonathan_oliveira
 */
  
// lombock gerar os get de todas as classes
//@Getter
// lombock declara um constructor sem argumentos
//@NoArgsConstructor
// lombock declara um constructor todos os argumentos
//@AllArgsConstructor


@Table(name = "foods")
@Entity(name = "foods") 
// id representação única 
@EqualsAndHashCode(of = "id")
public class Food {
    
    // Na produção usar Id aleatórios 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String image;
    Integer price;
    
    public Food(){
        super();
    }
    
    public Food(Long id, String title, String image, Integer price){
        super();
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
}
