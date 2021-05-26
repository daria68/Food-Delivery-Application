package services;

import entities.users.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class UserService {

    private static UserService user_instance = null;
    public static UserService getInstance()
    {
        if(user_instance == null)
            user_instance = new UserService();
        return user_instance;
    }
    private TreeSet<Client> clients;
    private TreeSet<Deliveryman> deliverymen;

    public UserService(){
        this.clients = new TreeSet<Client>();
        this.deliverymen = new TreeSet<Deliveryman>();
    }


    public Client createClient(){
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

        System.out.println("Date birth:");
        String birthDate = scanner.nextLine();
        String patternDate = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(patternDate);
        Date birthDateformat = null;
        try{
            birthDateformat = dateFormat.parse(birthDate);
        }
        catch(ParseException exception){
            System.out.println("Invalid birth date!");
        }


        Client client = new Client(firstName, lastName, username, password, phoneNumber, birthDateformat);
        clients.add(client);
        return client;
    }

    public TreeSet<Client> get_list_of_clients(){
        return this.clients;
    }

    public  Deliveryman createDeliveryman() {
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

        System.out.println("Date birth:");
        String birthDate = scanner.nextLine();

        System.out.println("Date hire:");
        String hireDate = scanner.nextLine();

        String patternDate = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(patternDate);
        Date birthDateformat = null;
        try{
            birthDateformat = dateFormat.parse(birthDate);
        }
        catch(ParseException exception){
            System.out.println("Invalid birth date!");
        }

        Date hireDateformat = null;
        try{
            hireDateformat = dateFormat.parse(hireDate);
        }
        catch(ParseException exception){
            System.out.println("Invalid hire date!");
        }


        System.out.println("Type of vehicle:");
        VehicleType vehicleType = VehicleType.valueOf(scanner.nextLine());

        Deliveryman deliveryman = new Deliveryman(firstName, lastName, username, password, phoneNumber, birthDateformat, hireDateformat, vehicleType);
        deliverymen.add(deliveryman);
        return deliveryman;
    }


    public TreeSet<Deliveryman> get_list_of_deliverymen(){
        return this.deliverymen;
    }

    public void displayAllClients(){
        for(Client client: clients){
            System.out.println(client);
        }
    }

    public void displayAllDeliverymen(){
        for(Deliveryman deliveryman: deliverymen){
            System.out.println(deliveryman);
        }
    }

}
