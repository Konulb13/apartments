package org.example;
import java.sql.*;
public class Main {

//    private static final String URL = "jdbc:mysql://localhost:3306/apartments";
//    private static final String USER = "root";
//    private static final String PASSWORD = "3713k";

    public static void main(String[] args) {
        selectFlats();
    }
    public static void selectFlats() {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("select * from flat"); ResultSet resultSet = preparedStatement.executeQuery();) {
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            while (resultSet.next()) {
//                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                    System.out.print(resultSet.getString(i) + "\t");
//                }
//                System.out.println();
//            }
//            resultSet.close();
//            preparedStatement.close();
//            if (!connection.isClosed()) {
//                System.out.println("Connection is closed");
//            }
//        } catch (SQLException e) {
//            System.out.println("there was a problem connecting to the database");
//            e.printStackTrace();
//        }
        DBConnect db = new DBConnect();
        String query = "select * from flat";
        try {
            Statement stmt = db.getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Apartments apartments = new Apartments();
                apartments.setId(resultSet.getInt(1));
                apartments.setQuantity_of_flat(resultSet.getInt(2));
                apartments.setPrice(resultSet.getInt(3));
                apartments.setDistrict(resultSet.getString(4));
                apartments.setAddress(resultSet.getString(5));
                apartments.setArea(resultSet.getInt(6));
                System.out.println(apartments);
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
    }

}