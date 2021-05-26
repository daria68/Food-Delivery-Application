package services;

import entities.menuitems.*;
import entities.users.Client;
import entities.users.Deliveryman;

import java.io.*;
import java.util.List;
import java.util.TreeSet;

public class FileWriter {
    private static FileWriter write_instance = null;

    public static FileWriter getInstance() {
        if (write_instance == null) write_instance = new FileWriter();
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
            java.io.FileWriter myWriter = new java.io.FileWriter("food.csv");
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
            File file = new File("drinks.csv");
            file.createNewFile();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter("drinks.csv");
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
            java.io.FileWriter myWriter = new java.io.FileWriter("client.csv");
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
            java.io.FileWriter myWriter = new java.io.FileWriter("deliveryman.csv");
            myWriter.write("");
            for (Deliveryman d : deliverymen)
                myWriter.write(d.getFirstName() + "," + d.getLastName() + "," + d.getUsername() + "," + d.getPhoneNumber() + "," + d.getbirthDate() + "," + d.getHireDate() + "," + d.getVehicleType()+"\n");

            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}