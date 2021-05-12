package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WorkMark extends WorkAutorisastion {

    private int Mark;

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
                System.out.println(w);
                statement.executeUpdate("UPDATE users SET mark = "+Mark+" WHERE login = '"+w+"'");


            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }
}
