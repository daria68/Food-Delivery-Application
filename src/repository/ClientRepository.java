package repository;

import entities.users.Client;
import config.DatabaseConfiguration;
import java.sql.*;


public class ClientRepository {

    //inserarea unui client in baza de date
    public void insertClientInDb(Client client){
        String preparedSql = "{call insertClientInDb(?,?,?,?,?,?)}";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(1, client.getFirstName());
            callableStatement.setString(2, client.getLastName());
            callableStatement.setString(3, client.getUsername());
            callableStatement.setString(4, client.getPassword());
            callableStatement.setString(5, client.getPhoneNumber());
            callableStatement.setDate(6, (Date) client.getbirthDate());
            //callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Client getClientByuserName(String  userName){
        String selectSql = "SELECT * FROM clients WHERE userName=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClient(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateClientfirstName(String firstName, String userName){
        String updatefirstNameSql = "UPDATE clients SET firstName =? WHERE userName=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updatefirstNameSql);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,userName);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Client mapToClient(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            return  new Client(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6));
        }
        return null;
    }

    public void deleteClient(String userName){
        String deleteSql ="DELETE FROM clients WHERE userName=?";

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
