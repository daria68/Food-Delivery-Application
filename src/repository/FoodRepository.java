package repository;

import entities.menuitems.Food;
import entities.menuitems.FoodType;
import config.DatabaseConfiguration;

import java.sql.*;

public class FoodRepository {

    public void insertFoodInDb(Food food){
        String preparedSql = "{call insertFoodInDb(?,?,?,?)}";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(1, food.getName());
            callableStatement.setDouble(2, food.getPrice());
            callableStatement.setDouble(3, food.getQuantity());
            callableStatement.setString(4, String.valueOf(food.getFoodType()));

            callableStatement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    public Food getFoodByitsName(String  name){
        String selectSql = "SELECT * FROM food WHERE name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToFood(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void updateFoodprice(Double price, String name){
        String updatepriceSql = "UPDATE food SET price =? WHERE name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updatepriceSql);
            preparedStatement.setDouble(1,price);
            preparedStatement.setString(2,name);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Food mapToFood(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            return  new Food(resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(3), FoodType.valueOf(resultSet.getString(4)));

        }
        return null;
    }

    public void deleteFood(String name){
        String deleteSql ="DELETE FROM food WHERE name=?";

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
