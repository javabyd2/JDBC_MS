package com.sda.exercise;

import java.sql.*;
import java.util.Scanner;

public class DataFromUser {


    public static void fromUser() throws SQLException {

        System.out.println("Choose from the menu below:\n" +
                "1. Add client\n2. Display client\n3. Edit client");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        Connection connection = DBConnectorNew.getConnection();
        Statement statement = connection.createStatement();

        switch (number) {
            case 1:
                String insert = "insert into customer (first_name, last_name, address, postal_code)values(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insert);
                System.out.println("podaj first name");
                preparedStatement.setString(1, scanner.next());
                System.out.println("podaj last name");
                preparedStatement.setString(2, scanner.next());
                System.out.println("podaj address");
                preparedStatement.setString(3, scanner.next());
                System.out.println("podaj postal code");
                preparedStatement.setString(4, scanner.next());
                preparedStatement.executeUpdate();
                break;
            case 2:
                String sql = "select * from customer";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("name: " + resultSet.getString("first_name")
                            + ("    last name: " + resultSet.getString("last_name"))
                            + "    address: " + resultSet.getString("address")
                            + "    postal code: " + resultSet.getString("postal_code"));
                }
                break;
            case 3:
                System.out.println("what do you want to update?\n" +
                        "1. first name\n2. last name\n3. address\n4. postal code");
                int number1 = scanner.nextInt();
                switch (number1) {
                    case 1:
                        System.out.println("provide new name");
                        String newName = scanner.next();
                        System.out.println("old name ");
                        String oldName = scanner.next();
                        String update = "update customer set first_name ='" + newName + "'where first_name ='" + oldName + "';";
                        statement.executeUpdate(update);
                        break;
                    case 2:
                        System.out.println("provide new last name");
                        String newLastName = scanner.next();
                        System.out.println("provide old last name");
                        String oldLastName = scanner.next();
                        String updateLastName = "update customer set first_name ='" + newLastName + "'where first_name ='" + oldLastName + "';";
                        statement.executeUpdate(updateLastName);
                        break;
                    case 3:
                        System.out.println("provide new address");
                        String newAddress = scanner.next();
                        System.out.println("provide old address");
                        String oldAddress = scanner.next();
                        String updateAddress = "update customer set address ='" + newAddress + "'where address ='" + oldAddress + "';";
                        statement.executeUpdate(updateAddress);
                        break;
                    case 4:
                        System.out.println("provide new postal code");
                        String newPostalCode = scanner.next();
                        System.out.println("provide old postal code");
                        String oldPostalCode = scanner.next();
                        String updatePostalCode = "update customer set address ='" + newPostalCode + "'where address ='" + oldPostalCode + "';";
                        statement.executeUpdate(updatePostalCode);
                        break;
                }
                break;
            default:
                System.out.println("You have not chosen anything from the list above");

        }
    }
}
