package com.sda.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Main {

//    public static final String JDBC_DRIVER = "" +
//            "com.mysql.cj.jdbc.Driver";
//    public static final String DB_URL = "" +
//            "jdbc:mysql://127.0.0.1/rental_db?useSSL=false&serverTimezone=UTC";
//    public static final String USER = "root";
//    public static String PASSWORD = "canoe261";


    public static void main(String[] args) {

        Connection connection = DBConnector.getConnection();;       // interface
        Statement statement = null;


        try {
            //Class.forName(JDBC_DRIVER);
            //connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

           // connection= DBConnector.getConnection();   // to jest wyniesione do gory ale moze byc tutaj a do connection przypisane null
            statement = connection.createStatement();
            String sql ="select * from customer";
            String sql1 = "select * from car";
            String sql2 ="select * from rent";
            ResultSet  resultSet =  statement.executeQuery(sql);
            System.out.println(resultSet);


            while(resultSet.next()){
                System.out.println("first name: "+resultSet.getString("first_name")
                        +("    last name: "+resultSet.getString("last_name"))
                        +"    adress: "+resultSet.getString("address")
                        +"    postal code: "+resultSet.getString("postal_code")
                        +"    email: "+resultSet.getString("email"));
            }
            System.out.println();

            ResultSet resultSet1 = statement.executeQuery(sql1);

            while(resultSet1.next()){
                System.out.println("reg number: "+resultSet1.getString("reg_number")
                        +("    brand: "+resultSet1.getString("mark"))
                        +"    model: "+resultSet1.getString("model")
                        +"    rate: "+resultSet1.getString("rate"));

            }

            System.out.println();

            ResultSet resultSet2 = statement.executeQuery(sql2);

            while(resultSet2.next()){
                System.out.println("cust id: "+resultSet2.getString("cust_id")
                        +("    reg number: "+resultSet2.getString("reg_number"))
                        +"    rent date: "+resultSet2.getString("rent_date")
                        +"    return date: "+resultSet2.getString("return_date"));

            }

//            String sql3 = "insert into car (reg_number, mark, model, rate)\n" +
//                    "values('SK 12345','Toyota','Yaris',4);";

            //ResultSet resultSet3 = statement.executeQuery(sql3);

//            String insert = "insert into car (reg_number, mark, model, rate)values('SE 66666','Ferrari','Spider','6')";
//            //statement.executeUpdate(insert);
//
//


//            Scanner scanner = new Scanner(System.in);
//            String insert1 = "insert into car (reg_number, mark, model, rate)values(?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(insert1);
//            System.out.println("podaj numer rejestracyjny");
//            preparedStatement.setString(1,scanner.nextLine());
//            System.out.println("podaj marke");
//            preparedStatement.setString(2,scanner.nextLine());
//            System.out.println("podaj model");
//            preparedStatement.setString(3,scanner.nextLine());
//            System.out.println("podaj rate");
//            preparedStatement.setString(4,scanner.nextLine());
//            preparedStatement.executeUpdate();


            //String update = "update car \n" +
                   // "set mark = 'Mitsubishi'\n" +
                    //"where mark = 'Trabant';";
            String update = "update car set mark = 'Fiacior' where mark = 'Mitsubishi';";
            statement.executeUpdate(update);


            String sql5 = "select * from car";
            ResultSet resultSet5 = statement.executeQuery(sql5);

            while(resultSet5.next()){
                System.out.println("reg number: "+resultSet5.getString("reg_number")
                        +("    brand: "+resultSet5.getString("mark"))
                        +"    model: "+resultSet5.getString("model")
                        +"    rate: "+resultSet5.getString("rate"));

            }

//            ResultSet rs = statement.executeQuery(sql);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            System.out.println("select * from customer");
//            int columnsNumber = rsmd.getColumnCount();
//            while (rs.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = rs.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println("");
//            }


            statement.executeQuery(sql);
            statement.executeQuery(sql1);
            statement.executeQuery(sql2);
            statement.executeQuery(sql5);

            //Thread.sleep(20000);
            //connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
