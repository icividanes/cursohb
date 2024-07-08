package com.example.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


 
public class Pizza extends EntityBase{
 
    private String name;   
    private String description;
    private String url;
    private List<Ingredient> ingredients;
 
 
    protected Pizza(UUID id, String name, String description, String url, List<Ingredient> ingredients) {
        super(id);
        this.name = name;        
        this.description = description;
        this.url = url;        
        this.ingredients = ingredients;
    }
    public void update(String name, String description, String url){
        this.name = name;
        this.description = description;
        this.url = url;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        double price = 0D;
        for (Ingredient ingredient : ingredients) {
            price +=ingredient.getPrice();
        }
        return price*1.2;
    }
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
    public List<Ingredient> getIngredient(){
        return ingredients;
    }
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }
    public static Pizza create(UUID id, String name, String Description, String url){
        return new Pizza(id, name, Description, url, new ArrayList<>());
    }
     
}
