package Main;

import Services.*;
import Users.*;
import Menu.*;

import java.text.ParseException;
import java.util.List;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {


    private static Restaurant CreateRestaurant(){
        Restaurant restaurant = new Restaurant();
        FoodType foodType1 = FoodType.MAIN_COURSE;
        FoodType foodType2 = FoodType.SALAD;
        FoodType foodType3 = FoodType.SAUCE;
        DrinkType drinkType1 = DrinkType.WATER;
        Food food1 = new Food("Spaghete Pomodoro",21.5, 400.0,foodType1);
        Food food2 = new Food("Caesar",25.7,450.0,foodType2);
        Food food3 = new Food("Pesto",9.5,50.0,foodType3);
        Drinks drink1 = new Drinks("Borsec",4.0,1.5,drinkType1);
        restaurant.addFood(food1);
        restaurant.addFood(food2);
        restaurant.addFood(food3);
        restaurant.addDrink(drink1);
        return restaurant;
    }

    public static void main(String[] args) throws ParseException {
        ReadFromFile citire = new ReadFromFile();
        WriteInFile scrie = new WriteInFile();
        Scanner scan = new Scanner(System.in);
        UserService orderService = new UserService();
        RestaurantService rservice = new RestaurantService(CreateRestaurant());
        Audit audit = new Audit();
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
            System.out.println("11.See all clients from csv file");
            System.out.println("12.See all deliveryman from csv file");
            System.out.println("13.Add new food to csv menu file");
            System.out.println("14.Add new drink to csv menu file");
            System.out.println("15.See the food menu from csv file");
            System.out.println("16.See the drinks menu from csv file");
            System.out.println("17.Add new clients to csv menu file");
            System.out.println("18.Add new deliverymen to csv menu file");
            opt = scan.nextInt();
            switch (opt){
                case 1:{
                    Client client = orderService.createClient();
                    audit.scrie("Client added");
                    break;
                }
                case 2:{
                    Deliveryman deliveryman = orderService.createDeliveryman();
                    audit.scrie("Deliveryman added");
                    break;
                }
                case 3:{
                    orderService.displayAllClients();
                    audit.scrie("Clients displayed");
                    break;
                }

                case 4:{
                    orderService.displayAllDeliverymen();
                    audit.scrie("Deliverymen displayed");
                    break;
                }

                case 5:{
                    FoodType foodType = FoodType.MAIN_COURSE;
                    rservice.addFood("Penne cu ciuperci",26.0, 500.0,foodType);
                    audit.scrie("Food added");
                    break;
                }

                case 6:{
                    DrinkType drinkType = DrinkType.BEER;
                    rservice.addDrink("Corona",11.75, 150.0,drinkType);
                    audit.scrie("Drink added");
                    break;
                }

                case 7: {
                    FoodType foodType = FoodType.MAIN_COURSE;
                    Food food = new Food("Penne cu ciuperci",26.0, 500.0,foodType);
                    rservice.removeFood(food);
                    audit.scrie("Food removed");
                    break;
                }

                case 8:{
                    DrinkType drinkType = DrinkType.BEER;
                    Drinks drink = new Drinks("Corona",11.75,150.0,drinkType);
                    rservice.removeDrink(drink);
                    audit.scrie("Drink removed");
                    break;
                }
                case 9:{
                    System.out.println("The price of all the food is "+ rservice.foodPrice());
                    audit.scrie("Food  price calculated");
                    break;
                }
                case 10:{
                    System.out.println("The price of all drinks is "+ rservice.drinksPrice());
                    audit.scrie("Drink  price calculated");
                    break;
                }
                case 11:{

                    TreeSet<Client> clients = citire.read_client();
                    for(Client c: clients)
                    {
                        System.out.println(c.toString());
                    }
                    break;
                }

                case 12:{

                    TreeSet<Deliveryman> deliverymen = citire.read_deliveryman();
                    for(Deliveryman d: deliverymen)
                    {
                        System.out.println(d.toString());
                    }
                    break;
                }

                case 13:{

                    scrie.write_food(rservice.get_list_of_food());
                    break;
                }

                case 14:{

                    scrie.write_drinks(rservice.get_list_of_drinks());
                    break;
                }
                case 15:{

                    List<Food> food = citire.read_food();
                    for(Food f: food)
                    {
                        System.out.println(f.toString());
                    }
                    break;
                }
                case 16:{

                    List<Drinks> drinks = citire.read_drinks();
                    for(Drinks d: drinks)
                    {
                        System.out.println(d.toString());
                    }
                    break;
                }
                case 17:{
                    scrie.write_client(orderService.get_list_of_clients());
                    break;
                }
                case 18:{
                    scrie.write_deliveryman(orderService.get_list_of_deliverymen());
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
