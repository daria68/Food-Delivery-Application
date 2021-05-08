package Services;
import Menu.*;
import Users.Client;
import Users.Deliveryman;
import Users.VehicleType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReadFromFile {
    private static ReadFromFile read_instance = null;
    public static ReadFromFile getInstance()
    {
        if(read_instance == null)
            read_instance = new ReadFromFile();
        return read_instance;
    }

    public List<Food> read_food()
    {
        List<Food> food = new ArrayList<Food>();
        try {
            RandomAccessFile file = new RandomAccessFile("food.csv", "r");
            String str;
            while((str = file.readLine()) != null)
            {
                String[] content = str.split(",");
                Food f = new Food(content[0], Double.valueOf(content[1]), Double.valueOf(content[2]), FoodType.valueOf(content[3]));
                food.add(f);

            }

            file.close();
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return food;
    }

    public List<Drinks> read_drinks()
    {
        List<Drinks> drinks = new ArrayList<Drinks>();
        try {
            RandomAccessFile file = new RandomAccessFile("Drinks.csv", "r");
            String str;
            while((str = file.readLine()) != null)
            {
                String[] content = str.split(",");
                Drinks d = new Drinks(content[0], Double.valueOf(content[1]), Double.valueOf(content[2]), DrinkType.valueOf(content[3]));
                drinks.add(d);

            }

            file.close();
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return drinks;
    }

    public TreeSet<Client> read_client() throws ParseException {
        TreeSet<Client> client = new TreeSet<Client>();
        try {
            RandomAccessFile file = new RandomAccessFile("client.csv", "r");
            String str;
            while((str = file.readLine()) != null)
            {
                String[] content = str.split(",");
                System.out.println(content[5].getClass().getSimpleName());

                Date date = new SimpleDateFormat("MM/dd/yyyy").parse(content[5]);
                Client c= new Client(content[0], content[1], content[2], content[3], content[4], date);
                client.add(c);

            }

            file.close();
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return client;
    }

    public TreeSet<Deliveryman> read_deliveryman() throws ParseException {
        TreeSet<Deliveryman> deliveryman = new TreeSet<Deliveryman>();
        try {
            RandomAccessFile file = new RandomAccessFile("deliveryman.csv", "r");
            String str;
            while((str = file.readLine()) != null)
            {
                String[] content = str.split(",");
                Date date = new SimpleDateFormat("MM/dd/yyyy").parse(content[5]);
                Date hire_date = new SimpleDateFormat("MM/dd/yyyy").parse(content[6]);
                Deliveryman d= new Deliveryman(content[0], content[1], content[2], content[3], content[4], date, hire_date, VehicleType.valueOf(content[7]));
                deliveryman.add(d);

            }

            file.close();
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return deliveryman;
    }
}
