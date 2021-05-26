package usermenu;

import services.*;
import entities.menuitems.DrinkType;
import entities.menuitems.Drinks;
import entities.menuitems.FoodType;
import entities.users.Client;
import entities.users.Deliveryman;
import entities.users.VehicleType;
import entities.menuitems.Food;
import config.DatabaseSetup;
import repository.ClientRepository;
import repository.DeliverymanRepository;
import repository.DrinksRepository;
import repository.FoodRepository;

import java.text.ParseException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;
import config.*;


public class DBMenu {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        DatabaseSetup setUpData = new DatabaseSetup();

        //pentru citirea de la tastatura
        UserService orderService = new UserService();

        setUpData.setUp();

        ClientRepository clientRepository = new ClientRepository();
        DeliverymanRepository deliverymanRepository = new DeliverymanRepository();
        FoodRepository foodRepository = new FoodRepository();
        DrinksRepository drinksRepository = new DrinksRepository();

        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        //CREATE
        //Client
        //setUpData.addClient();
        //clientRepository.insertClientInDb(new Client("Costache","Giurgiuveanu","cgiurgiuveanu", "otilia08", "0729066778",date));

        //Deliveryman
        //setUpData.addDeliveryman();
        //deliverymanRepository.insertDeliverymanInDb(new Deliveryman("Zaharia","Trahanache","ztrahanache", "zoe08", "0727066778",date,date, VehicleType.SCOOTER));

        //Food
        //setUpData.addFood();
        //foodRepository.insertFoodInDb(new Food("Athena",22.99,420.0, FoodType.SALAD));

        //Drinks
        //setUpData.addDrink();
        //drinksRepository.insertDrinkInDb(new Drinks("Corona",11.75, 1.5, DrinkType.BEER));

        //READ
        Client client = clientRepository.getClientByuserName("vlipan06");
        System.out.println("Full name is " + client.getFirstName() + " " + client.getLastName());

        Deliveryman deliveryman = deliverymanRepository.getDeliverymanByphoneNumber("0727066778");
        System.out.println("Full name is " + deliveryman.getFirstName() + " " + deliveryman.getLastName());

        Food food = foodRepository.getFoodByitsName("Clatite");
        System.out.println("The price and quantity of " + food.getName() + " is " + food.getPrice() + " RON, " + food.getQuantity() + " g");

        Drinks drink = drinksRepository.getDrinkByitsName("Corona");
        System.out.println("The type of " + drink.getName() + " is " + drink.getDrinkType());

        //UPDATE
        clientRepository.updateClientfirstName("Costachewithupdate","cgiurgiuveanu");
        Client updatedClient = clientRepository.getClientByuserName("cgiurgiuveanu");
        System.out.println("Full updated name is " + updatedClient .getFirstName() + " " + updatedClient .getLastName());

        deliverymanRepository.updateDeliverymanphoneNumber("TheNewZaharia","0727066778");
        Deliveryman updatedDeliveryman = deliverymanRepository.getDeliverymanByphoneNumber("0727066778");
        System.out.println("Full updated name is " + updatedDeliveryman.getFirstName() + " " + updatedDeliveryman.getLastName());

        foodRepository.updateFoodprice(25.99,"Athena");
        Food updatedFood = foodRepository.getFoodByitsName("Athena");
       // System.out.println("The new price of " + updatedFood.getName() + " is " + updatedFood.getPrice());

        drinksRepository.updateDrinkquantity(1.75,"Corona");
        Drinks updatedDrink = drinksRepository.getDrinkByitsName("Corona");
        System.out.println("The new quantity of " + updatedDrink.getName() + " is " + updatedDrink.getQuantity());

        //DELETE
        //clientRepository.insertClientInDb(new Client("Iona","Iona","iona_in_balena01", "iona123!", "0876543221",date));
        //clientRepository.deleteClient("iona_in_balena01");

        //deliverymanRepository.insertDeliverymanInDb(new Deliveryman("Goe","Domnul","dlgoedintren", "goe!1234", "0654321998",date,date, VehicleType.KICKBOARD));
        //deliverymanRepository.deleteDeliveryman("dlgoedintren");

        //foodRepository.insertFoodInDb(new Food("Lava Cake",30.50,220.0, FoodType.DESERT));
        //foodRepository.deleteFood("Lava Cake");

        //drinksRepository.insertDrinkInDb(new Drinks("Vodka Martini",34.99, 0.2, DrinkType.COCKTAIL));
        //drinksRepository.deleteDrink("Vodka Martini");

        int opt = -1;
        while(opt != 0){
            System.out.println("Choose from the options bellow:");
            System.out.println("0.Exit");
            System.out.println("1.Create a new client");
            System.out.println("2.Create a new deliveryman");
            System.out.println("3.Create new food");
            System.out.println("4.Create new drinks");
            System.out.println("5.Update client");
            System.out.println("6.Update deliveryman");
            System.out.println("7.Update food");
            System.out.println("8.Update drink");
            System.out.println("9.Delete a client");
            System.out.println("10.Delete a deliveryman");
            System.out.println("11.Delete food");
            System.out.println("12.Delete drink");

            opt = scan.nextInt();
            switch (opt){
                case 1:{
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("First name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Last name:");
                    String lastName = scanner.nextLine();

                    System.out.println("Username:");
                    String username = scanner.nextLine();

                    System.out.println("Password:");
                    String password = scanner.nextLine();

                    System.out.println("Phone number:");
                    String phoneNumber = scanner.nextLine();

                    System.out.println("Date birth, pattern YYYY-MM-DD:");
                    String birthDate = scanner.nextLine();
                    Date dateC =Date.valueOf(birthDate);
                    clientRepository.insertClientInDb(new Client(firstName, lastName, username,password,phoneNumber,dateC));
                    break;
                }
                case 2:{
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("First name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Last name:");
                    String lastName = scanner.nextLine();

                    System.out.println("Username:");
                    String username = scanner.nextLine();

                    System.out.println("Password:");
                    String password = scanner.nextLine();

                    System.out.println("Phone number:");
                    String phoneNumber = scanner.nextLine();

                    System.out.println("Date birth, pattern YYYY-MM-DD:");
                    String birthDate = scanner.nextLine();
                    Date dateD =Date.valueOf(birthDate);

                    System.out.println("Date hire, pattern YYYY-MM-DD:");
                    String hireDate = scanner.nextLine();
                    Date datehireD =Date.valueOf(hireDate);

                    System.out.println("Type of vehicle:");
                    VehicleType vehicleType = VehicleType.valueOf(scanner.nextLine());

                    deliverymanRepository.insertDeliverymanInDb(new Deliveryman(firstName, lastName, username,password,phoneNumber,dateD,datehireD,vehicleType));
                    break;
                }
                case 3:{
                    foodRepository.insertFoodInDb(new Food("Pizza",25.99,450.0, FoodType.MAIN));
                    break;
                }

                case 4:{
                    drinksRepository.insertDrinkInDb(new Drinks("Sangria",30.0,0.5, DrinkType.WINE));
                    break;
                }

                case 5:{
                    System.out.println("Choose the username of the client you want to update");
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
                    Scanner scanner = new Scanner(System.in);

                    try {
                        Integer id =1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT firstName, userName from clients");
                        System.out.println("        User Name       " + "First Name");
                        while(rs.next()){

                            System.out.println("\t" + id.toString() + ". " + rs.getString("userName") + ", " + rs.getString("firstName"));
                            id +=1;
                        }

                        System.out.println("\t\tPlease enter the User Name of the client you want to modify:");
                        String userName = scanner.nextLine();
                        System.out.println("\t\tPlease enter the new First Name of the client you want to modify:");
                        String firstName = scanner.nextLine();
                        clientRepository.updateClientfirstName(firstName,userName);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }

                case 6:{
                    System.out.println("Choose the phone number of the deliveryman you want to update");
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
                    Scanner scanner = new Scanner(System.in);

                    try {
                        Integer id =1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT firstName, phoneNumber from deliverymen");
                        System.out.println("        First Name       " + "Phone Number");
                        while(rs.next()){

                            System.out.println("\t" + id.toString() + ". " + rs.getString("phoneNumber") + ", " + rs.getString("firstName"));
                            id +=1;
                        }

                        System.out.println("\t\tPlease enter the Phone Number of the deliveryman you want to modify:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("\t\tPlease enter the new First Name of the deliveryman you want to modify:");
                        String firstName = scanner.nextLine();
                        deliverymanRepository.updateDeliverymanphoneNumber(firstName,phoneNumber);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }

                case 7: {
                    System.out.println("Choose the name of the food you want to update");
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
                    Scanner scanner = new Scanner(System.in);

                    try {
                        Integer id =1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT name, price from food");
                        System.out.println("        Name       " + "Quantity");
                        while(rs.next()){

                            System.out.println("\t" + id.toString() + ". " + rs.getString("name") + ", " + rs.getDouble("price"));
                            id +=1;
                        }

                        System.out.println("\t\tPlease enter the Name of the food you want to modify:");
                        String name = scanner.nextLine();
                        System.out.println("\t\tPlease enter the new Price of the food you want to modify:");
                        Double price = scanner.nextDouble();
                        foodRepository.updateFoodprice(price,name);


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }

                case 8:{
                    System.out.println("Choose the name of the drink you want to update");
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
                    Scanner scanner = new Scanner(System.in);

                    try {
                        Integer id =1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT name, quantity from drinks");
                        System.out.println("        Name       " + "Quantity");
                        while(rs.next()){

                            System.out.println("\t" + id.toString() + ". " + rs.getString("name") + ", " + rs.getDouble("quantity"));
                            id +=1;
                        }

                        System.out.println("\t\tPlease enter the Name of the drink you want to modify:");
                        String name = scanner.nextLine();
                        System.out.println("\t\tPlease enter the new Quantity of the food you want to modify:");
                        Double quantity = scanner.nextDouble();
                        drinksRepository.updateDrinkquantity(quantity,name);


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }
                case 9:{
                    System.out.println("Choose the username of the client you want to delete");
                    Scanner scanner = new Scanner(System.in);
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

                    try {
                        Integer id = 1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT userName from clients");
                        while (rs.next()) {
                            System.out.println("\t" + id.toString() + ". " + rs.getString("userName"));
                            id += 1;
                        }

                        System.out.println("\t\tPlease enter the username:");
                        String userName = scanner.nextLine();
                        clientRepository.deleteClient(userName);
                        System.out.println("Client " + userName + "  has been deleted from the table");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    break;
                }
                case 10:{
                    System.out.println("Choose the username of the deliveryman you want to delete");
                    Scanner scanner = new Scanner(System.in);
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

                    try {
                        Integer id = 1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT userName from deliverymen");
                        while (rs.next()) {
                            System.out.println("\t" + id.toString() + ". " + rs.getString("userName"));
                            id += 1;
                        }

                        System.out.println("\t\tPlease enter the username:");
                        String userName = scanner.nextLine();
                        deliverymanRepository.deleteDeliveryman(userName);
                        System.out.println("Deliveryman " + userName + "  has been deleted from the table");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }
                case 11:{
                    System.out.println("Choose the name of the food you want to delete");
                    Scanner scanner = new Scanner(System.in);
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

                    try {
                        Integer id = 1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT name from food");
                        while (rs.next()) {
                            System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                            id += 1;
                        }

                        System.out.println("\t\tPlease enter the name:");
                        String name = scanner.nextLine();
                        foodRepository.deleteFood(name);
                        System.out.println("Food " + name + "  has been deleted from the table");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }

                case 12:{
                    System.out.println("Choose the name of the drink you want to delete");
                    Scanner scanner = new Scanner(System.in);
                    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

                    try {
                        Integer id = 1;
                        Statement stm = databaseConnection.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT name from drinks");
                        while (rs.next()) {
                            System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                            id += 1;
                        }

                        System.out.println("\t\tPlease enter the name:");
                        String name = scanner.nextLine();
                        drinksRepository.deleteDrink(name);
                        System.out.println("Drink " + name + "  has been deleted from the table");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
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
