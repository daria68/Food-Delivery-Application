package config;
import repository.Repository;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseSetup {

    public void setUp() {
    String createTableDeliverymanSql = "CREATE TABLE IF NOT EXISTS deliverymen" +
            "(firstName varchar(20), lastName varchar(20),"+
            "username varchar(20) PRIMARY KEY, password varchar(15)," +
            "phoneNumber varchar(10), birthDate date, hireDate date, vechicleType varchar(10))";
    String createTableClientSql = "CREATE TABLE IF NOT EXISTS clients" +
            "(firstName varchar(20), lastName varchar(20),"+
            "username varchar(20) PRIMARY KEY, password varchar(15)," +
            "phoneNumber varchar(10), birthDate date)";
    String createTableFoodSql = "CREATE TABLE IF NOT EXISTS food" +
            "(name varchar(20) PRIMARY KEY, price double," +
            "quantity double, foodType varchar(15))";
    String createTableDrinksSql = "CREATE TABLE IF NOT EXISTS drinks" +
            "(name varchar(20) PRIMARY KEY, price double," +
            "quantity double, drinkType varchar(10))";
    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
    Repository repository = Repository.getRepository();
        try {
            repository.executeSql(databaseConnection, createTableDeliverymanSql);
            repository.executeSql(databaseConnection, createTableClientSql);
            repository.executeSql(databaseConnection, createTableFoodSql);
            repository.executeSql(databaseConnection, createTableDrinksSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(){
        String insertClientSql ="INSERT INTO clients(firstName, lastName, userName, password, phoneNumber, birthDate) VALUES('Vitoria','Lipan','vlipan06', 'nechifor', '0729066778','2000-08-06')";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Repository repository = Repository.getRepository();

        try{
            repository.executeUpdateSql(databaseConnection, insertClientSql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addDeliveryman(){
        String insertDeliverymanSql ="INSERT INTO deliverymen(firstName, lastName, userName, password, phoneNumber, birthDate, hireDate, vechicleType) VALUES('Vitoria','Lipan','vlipan06', 'nechifor', '0729066778','2000-08-06', '2015-06-06', 'SCOOTER')";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Repository repository = Repository.getRepository();

        try{
            repository.executeUpdateSql(databaseConnection, insertDeliverymanSql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addFood(){
        String insertFoodSql ="INSERT INTO food(name, price, quantity, foodType) VALUES('Clatite',11.5,250.0,'DESERT')";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Repository repository = Repository.getRepository();

        try{
            repository.executeUpdateSql(databaseConnection, insertFoodSql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addDrink(){
        String insertDrinkSql ="INSERT INTO drinks(name, price, quantity, drinkType) VALUES('Aqua Carpatica',6.49,2.5,'WATER')";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Repository repository = Repository.getRepository();

        try{
            repository.executeUpdateSql(databaseConnection, insertDrinkSql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
