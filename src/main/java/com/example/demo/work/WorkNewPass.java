package com.example.demo.work;

import java.sql.*;

public class WorkNewPass extends WorkAutorisastion{
    private String newpass;

    public void work()
    {
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                String w = noOfInstances;
                statement.executeUpdate("UPDATE users SET password = '"+newpass+"' WHERE login = '"+w+"'");

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }
}
