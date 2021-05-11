package Services;

import Menu.*;
import Users.Client;
import Users.Deliveryman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WriteInFile {
    private static WriteInFile write_instance = null;

    public static WriteInFile getInstance() {
        if (write_instance == null) write_instance = new WriteInFile();
        return write_instance;
    }


    public void write_food(List<Food> food) {
        try {
            File file = new File("food.csv");
            file.createNewFile();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("food.csv");
            myWriter.write("");
            for (Food f : food)
                myWriter.write(f.getName() + "," + f.getPrice() + "," + f.getQuantity() + "," + f.getFoodType() + "\n");

            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public void write_drinks(List<Drinks> drinks) {
        try {
            File file = new File("Drinks.csv");
            file.createNewFile();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("Drinks.csv");
            myWriter.write("");
            for (Drinks d : drinks)
                myWriter.write(d.getName() + "," + d.getPrice() + "," + d.getQuantity() + "," + d.getDrinkType() + "\n");

            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public void write_client(TreeSet<Client> clients) {
        try {
            File file = new File("client.csv");
            file.createNewFile();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("client.csv");
            myWriter.write("");
            for (Client c : clients)
                myWriter.write(c.getFirstName() + "," + c.getLastName() + "," + c.getUsername() + "," + c. getPassword()+  "," + c.getPhoneNumber() + "," +c.getbirthDate() +"\n");

            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public void write_deliveryman(TreeSet<Deliveryman> deliverymen) {
        try {
            File file = new File("deliveryman.csv");
            file.createNewFile();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("deliveryman.csv");
            myWriter.write("");
            for (Deliveryman d : deliverymen)
                myWriter.write(d.getFirstName() + "," + d.getLastName() + "," + d.getUsername() + "," + d.getPhoneNumber() + "," + d.getbirthDate() + "," + d.getHireDate() + "," + d.getVehicleType()+"\n");

            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}