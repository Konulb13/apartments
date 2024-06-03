package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("if you want to create the table click 1 ");
            System.out.println("if you want to add to the table click 2 ");
            System.out.println("if you want to see the table click 3 ");
            System.out.println("if you want to delete the table click 4 ");

            switch (sc.nextInt()) {

                case 1:
                    createTable();
                    break;
                case 2:
                    add(sc);
                    break;
                case 3:
                    selectFlats();
                    break;
                case 4:
                    deleteFlats(sc);
                    break;
            }
        }
    }

    static DBConnect db = new DBConnect();


    private static void createTable() throws SQLException {
        Statement st = db.getConnection().createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS flat");
            st.execute("CREATE TABLE flat (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "district VARCHAR(255) NOT NULL, " +
                    "address VARCHAR(255) NOT NULL, " +
                    "area INT NOT NULL, " +
                    "quantity_of_flat INT NOT NULL, " +
                    "price FLOAT NOT NULL)");
        } finally {
            st.close();
        }
    }

    public static void add(Scanner sc) throws SQLException {
        System.out.print("flat quantity_of_flat? ");
        String q = sc.next();
        int quantityOfFlat = Integer.parseInt(q);

        System.out.print("flat apartment price? ");
        String apartmentPrice = sc.next();
        float price = Float.parseFloat(apartmentPrice);

        System.out.print("flat district? ");
        String district = sc.next();

        System.out.print("flat address? ");
        String address = sc.next();

        System.out.print("flat area? ");
        String a = sc.next();
        int area = Integer.parseInt(a);

        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO flat (quantity_of_flat,price,district,address,area) values (?,?,?,?,?)");
        try {
            ps.setInt(1, quantityOfFlat);
            ps.setFloat(2, price);
            ps.setString(3, district);
            ps.setString(4, address);
            ps.setInt(5, area);
            ps.executeUpdate();
        } finally {
            ps.close();
        }

    }

    public static void selectFlats() {
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

    private static void deleteFlats(Scanner sc) throws SQLException {
        System.out.print("Enter flat ID ");
        String id = sc.next();

        PreparedStatement ps = db.getConnection().prepareStatement("DELETE FROM flat WHERE id = ?");
        try {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

}
