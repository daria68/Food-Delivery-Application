package Services;

import Menu.*;
import Users.Restaurant;

public class RestaurantService {
    private Restaurant restaurant;

    public RestaurantService(){}
    public RestaurantService(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    //add food to the restaurant menu
    public void addFood(String name, Double price, Double quantity, FoodType foodType)
    {
        Food food = new Food(name, price, quantity,foodType);
        restaurant.addFood(food);
    }

    //remove food from the restaurant menu
    public void removeFood(Food food){
        for(Food f :restaurant.getFood_options())
            if((f.getName()).equals(food.getName())) {
                restaurant.removeFood(food);
                break;
            }
    }

    //add food to the restaurant menu
    public void addDrink(String name, Double price, Double quantity, DrinkType drinkType)
    {
        Drinks drink = new Drinks(name, price, quantity,drinkType);
        restaurant.addDrink(drink);
    }

    //remove food from the restaurant menu
    public void removeDrink(Drinks drink){
        for(Drinks d :restaurant.getDrinks_options())
            if((d.getName()).equals(drink.getName())) {
                restaurant.removeDrink(drink);
                break;
            }
    }

    //calculate total price of food from restaurant
    public double foodPrice(){
        double total_price = 0;
        for(Food food : restaurant.getFood_options())
            total_price+= food.getPrice();
        return total_price;
    }
    //calculate total price of drinks from restaurant
    public double drinksPrice(){
        double total_price = 0;
        for(Drinks drink : restaurant.getDrinks_options())
            total_price+= drink.getPrice();
        return total_price;
    }
}
