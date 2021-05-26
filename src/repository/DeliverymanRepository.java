package repository;

import entities.users.Deliveryman;
import entities.users.VehicleType;
import config.DatabaseConfiguration;

import java.sql.*;

public class DeliverymanRepository {

    public void insertDeliverymanInDb(Deliveryman deliveryman){
        String preparedSql = "{call insertDeliverymanInDb(?,?,?,?,?,?,?,?)}";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(1, deliveryman.getFirstName());
            callableStatement.setString(2, deliveryman.getLastName());
            callableStatement.setString(3, deliveryman.getUsername());
            callableStatement.setString(4, deliveryman.getPassword());
            callableStatement.setString(5, deliveryman.getPhoneNumber());
            callableStatement.setDate(6, (Date) deliveryman.getbirthDate());
            callableStatement.setDate(7,(Date) deliveryman.getHireDate());
            callableStatement.setString(8,String.valueOf(deliveryman.getVehicleType()));
            callableStatement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Deliveryman getDeliverymanByphoneNumber(String  phoneNumber){
        String selectSql = "SELECT * FROM deliverymen WHERE phoneNumber=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDeliveryman(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateDeliverymanphoneNumber(String firstName, String phoneNumber){
        String updatephoneNumberSql = "UPDATE deliverymen SET firstName =? WHERE phoneNumber=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updatephoneNumberSql);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,phoneNumber);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Deliveryman mapToDeliveryman(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            return  new Deliveryman(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
                    resultSet.getDate(7), VehicleType.valueOf(resultSet.getString(8)));


        }
        return null;
    }

    public void deleteDeliveryman(String userName){
        String deleteSql ="DELETE FROM deliverymen WHERE userName=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);

            preparedStatement.setString(1, userName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
