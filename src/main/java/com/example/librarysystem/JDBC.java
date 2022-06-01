package com.example.librarysystem;
import java.sql.*;
public class JDBC {
    public void test() {

        try {
            //when using awad's database use password "32484463248446"
            //when using hussein's database use password "toor"
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "rootpassword");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
