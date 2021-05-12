package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WorkDeleteUser {
    private String login;
    int t=0;

    public void work()
    {
        System.out.println(login);





        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                PreparedStatement st = conn.prepareStatement("DELETE FROM users  WHERE login = ?");
                st.setString(1,login);
                st.executeUpdate();

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
