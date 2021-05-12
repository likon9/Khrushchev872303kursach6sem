package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WorkDeleteQuestion {

    private  int id;

    public void work()
    {

        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                PreparedStatement st = conn.prepareStatement("DELETE FROM question WHERE idquestion = ?");
                st.setInt(1,id);
                st.executeUpdate();

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }

    public void setId(int id) {
        this.id = id;
    }
}
