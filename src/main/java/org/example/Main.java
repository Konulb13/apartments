package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        selectFlats();
    }
    public static void selectFlats() {
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
