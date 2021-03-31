package Users;
import Menu.*;

import java.util.*;

public class Restaurant {
    private String name;
    private String location;

    //Composition
    private List<Food> food_options;
    private List<Drinks> drinks_options;

    public Restaurant() {
        this.food_options = new ArrayList<>();
        this.drinks_options = new ArrayList<>();
    }
    public Restaurant(String name, String location, List<Food> food_options, List<Drinks> drinks_options){
        this.name = name;
        this.location = location;
        this.food_options = food_options;
        this.drinks_options = drinks_options;
    }

    public String getName() {

        return name;
    }

    public String getLocation() {

        return location;
    }

    public List<Food> getFood_options() {

        return food_options;
    }

    public List<Drinks> getDrinks_options() {

        return drinks_options;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public void setFood_options(List<Food> food_options) {

        this.food_options = food_options;
    }

    public void setDrinks_options(List<Drinks> drinks_options) {

        this.drinks_options = drinks_options;
    }

    //methods that add/remove/find food and drinks to/in the restaurant
    public void addFood(Food food) {

        food_options.add(food);
    }

    public void addDrink(Drinks drink) {

        drinks_options.add(drink);
    }

    public void removeFood(Food food){

        food_options.remove(food);
    }

    public void removeDrink(Drinks drink){

        drinks_options.remove(drink);
    }

    public Boolean findFood(Food food){
        if(food_options.isEmpty()){
            return false;
        }
        return food_options.contains(food);
    }

    public Boolean findDrink(Drinks drink){
        if(drinks_options.isEmpty()){
            return false;
        }
        return drinks_options.contains(drink);
    }

}

