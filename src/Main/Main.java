package Main;

import Services.UserService;
import Services.RestaurantService;
import Users.*;
import Menu.*;

import java.util.Scanner;
public class Main {


    private static Restaurant CreateRestaurant(){
        Restaurant restaurant = new Restaurant();
        FoodType foodType1 = FoodType.MAIN_COURSE;
        FoodType foodType2 = FoodType.SALAD;
        FoodType foodType3 = FoodType.SAUCE;
        Food food1 = new Food("Spaghete Pomodoro",21.5, 400.0,foodType1);
        Food food2 = new Food("Caesar",25.7,450.0,foodType2);
        Food food3 = new Food("Pesto",9.5,50.0,foodType3);
        restaurant.addFood(food1);
        restaurant.addFood(food2);
        restaurant.addFood(food3);
        return restaurant;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        UserService orderService = new UserService();
        RestaurantService rservice = new RestaurantService(CreateRestaurant());
        int opt = -1;
        while(opt != 0){
            System.out.println("Choose from the options bellow:");
            System.out.println("0.Exit");
            System.out.println("1.Add a new client to the platform");
            System.out.println("2.Add a new deliveryman to the platform");
            System.out.println("3.Display all clients");
            System.out.println("4.Display all deliverymen");
            System.out.println("5.Add food to restaurant menu");
            System.out.println("6.Add drink to resturant menu");
            System.out.println("7.Remove food");
            System.out.println("8.Remove drink");
            System.out.println("9.Calculate the total price of the food");
            System.out.println("10.Calculate the total price of the drink");
            opt = scan.nextInt();
            switch (opt){
                case 1:{
                    Client client = orderService.createClient();
                    break;
                }
                case 2:{
                    Deliveryman deliveryman = orderService.createDeliveryman();
                    break;
                }
                case 3:{
                    orderService.displayAllClients();
                    break;
                }

                case 4:{
                    orderService.displayAllDeliverymen();
                    break;
                }

                case 5:{
                    FoodType foodType = FoodType.MAIN_COURSE;
                    rservice.addFood("Penne cu ciuperci",26.0, 500.0,foodType);
                    break;
                }

                case 6:{
                    DrinkType drinkType = DrinkType.BEER;
                    rservice.addDrink("Corona",11.75, 150.0,drinkType);
                    break;
                }

                case 7: {
                    FoodType foodType = FoodType.MAIN_COURSE;
                    Food food = new Food("Penne cu ciuperci",26.0, 500.0,foodType);
                    rservice.removeFood(food);
                    break;
                }

                case 8:{
                    DrinkType drinkType = DrinkType.BEER;
                    Drinks drink = new Drinks("Corona",11.75,150.0,drinkType);
                    rservice.removeDrink(drink);
                    break;
                }
                case 9:{
                    System.out.println("The price of all the food is "+ rservice.foodPrice());
                    break;
                }
                case 10:{
                    System.out.println("The price of all drinks is "+ rservice.drinksPrice());
                    break;
                }
                case 0:{
                    System.out.println("Thank you for using this app!");
                    break;
                }
            }
        }
       }
}
