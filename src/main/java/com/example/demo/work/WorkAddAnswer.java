package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WorkAddAnswer {

    private int id;
    private String answer;

    public void work()
    {
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE question SET answer = '"+answer+"' WHERE idquestion = '"+id+"'");
                System.out.println("qqweqwe");

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
