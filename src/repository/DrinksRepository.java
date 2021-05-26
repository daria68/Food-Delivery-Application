package repository;

import entities.menuitems.Drinks;
import entities.menuitems.DrinkType;
import config.DatabaseConfiguration;

import java.sql.*;

public class DrinksRepository {
    public void insertDrinkInDb(Drinks drinks){
        String preparedSql = "{call insertDrinkInDb(?,?,?,?)}";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(1, drinks.getName());
            callableStatement.setDouble(2, drinks.getPrice());
            callableStatement.setDouble(3, drinks.getQuantity());
            callableStatement.setString(4, String.valueOf(drinks.getDrinkType()));

            callableStatement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    public Drinks getDrinkByitsName(String  name){
        String selectSql = "SELECT * FROM drinks WHERE name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDrinks(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void updateDrinkquantity(Double quantity, String name){
        String updatequantitySql = "UPDATE drinks SET quantity =? WHERE name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updatequantitySql);
            preparedStatement.setDouble(1,quantity);
            preparedStatement.setString(2,name);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Drinks mapToDrinks(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            return  new Drinks(resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(3), DrinkType.valueOf(resultSet.getString(4)));
        }
        return null;
    }

    public void deleteDrink(String name){
        String deleteSql ="DELETE FROM drinks WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
